package com.example.itcity.THEORY_TASK.algorithm;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.abs;

import android.app.Dialog;
import android.content.Context;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itcity.R;

import java.util.ArrayList;

public class ZadanieAlgorithm6 extends AppCompatActivity {
    ArrayList<PuzzlePiece> pieces;
    int res;
    Button button5;
    String strres;
    Dialog dialog;
    Button Check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algtask6);
        getSupportActionBar().hide();
        button5 = findViewById(R.id.button5);
        Check = findViewById(R.id.algCheck);
        final RelativeLayout layout = findViewById(R.id.Alayout);
        pieces = splitImage();
        TouchListener touchListener = new TouchListener();
        for (PuzzlePiece piece : pieces) {
            piece.setOnTouchListener(touchListener);
            layout.addView(piece);
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button5:
                        Intent intent = new Intent(ZadanieAlgorithm6.this, TheoryAlgorithm6.class);
                        startActivity(intent);
                        break;
                    case R.id.algCheck:
                        for (int i = 0; i < pieces.size(); i++) {
                            if (pieces.get(i).canMove == false ) {
                                res += 11;
                            }
                        }
                        if (res == 99) {res += 1;}
                        dialog = new Dialog(ZadanieAlgorithm6.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.markgooddialogwindow);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        //кнопки начало

                        //кнопки конец
                        TextView result = dialog.findViewById(R.id.mark_for_the_lvl);
                        strres = Integer.toString(res);
                        result.setText(strres);
                        dialog.show();//показ окна

                        Button back_to_houses= dialog.findViewById(R.id.button10);
                        back_to_houses.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(ZadanieAlgorithm6.this, Algorithm_HOME.class);
                                startActivity(intent);
                            }
                        });
                        //ЕСЛИ БЫЛ ЗАПУЩЕН ЭТОТ БЛОК КОДА МЕНЯЕМ КОЛИЧЕСТВО БАЛЛОВ В FIREBASE  И В ПЕРЕМЕННУЮ В КОТОРОЙ НАШ УРОВЕНЬ ДЕЛАЕМ +1;
                        break;
                }
            }
        };
        button5.setOnClickListener(onClickListener);
        Check.setOnClickListener(onClickListener);
    }

    private ArrayList<PuzzlePiece> splitImage() {
        int piecesNumber = 9;
        int rows = 3;
        int cols = 3;

        ImageView imageView = findViewById(R.id.imageView);
        ArrayList<PuzzlePiece> pieces = new ArrayList<>(piecesNumber);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.algpuzzle7);

        int pieceWidth = bitmap.getWidth()/cols;
        int pieceHeight = bitmap.getHeight()/rows;

        int yCoord = 0;
        for (int row = 0; row < rows; row++) {
            int xCoord = 0;
            for (int col = 0; col < cols; col++) {
                Bitmap pieceBitmap = Bitmap.createBitmap(bitmap, xCoord, yCoord, pieceWidth, pieceHeight);
                PuzzlePiece piece = new PuzzlePiece(getApplicationContext());
                piece.setImageBitmap(pieceBitmap);
                piece.xCoord = xCoord;
                piece.yCoord = yCoord;
                piece.pieceWidth = pieceWidth;
                piece.pieceHeight = pieceHeight;
                pieces.add(piece);
                xCoord += pieceWidth;
            }
            yCoord += pieceHeight;
        }

        return pieces;
    }

    public class TouchListener implements View.OnTouchListener {
        private float xDelta;
        private float yDelta;

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float x = motionEvent.getRawX();
            float y = motionEvent.getRawY();
            final double tolerance = sqrt(pow(view.getWidth(), 2) + pow(view.getHeight(), 2)) / 10;

            PuzzlePiece piece = (PuzzlePiece) view;
            if (!piece.canMove) {
                return true;
            }

            RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    xDelta = x - lParams.leftMargin;
                    yDelta = y - lParams.topMargin;
                    piece.bringToFront();
                    break;
                case MotionEvent.ACTION_MOVE:
                    lParams.leftMargin = (int) (x - xDelta);
                    lParams.topMargin = (int) (y - yDelta);
                    view.setLayoutParams(lParams);
                    break;
                case MotionEvent.ACTION_UP:
                    int xDiff = abs(piece.xCoord - lParams.leftMargin);
                    int yDiff = abs(piece.yCoord - lParams.topMargin);
                    if (xDiff <= tolerance && yDiff <= tolerance) {
                        lParams.leftMargin = piece.xCoord;
                        lParams.topMargin = piece.yCoord;
                        piece.setLayoutParams(lParams);
                        piece.canMove = false;
                        sendViewToBack(piece);
                    }
                    break;
            }

            return true;
        }

        public void sendViewToBack(final View child) {
            final ViewGroup parent = (ViewGroup)child.getParent();
            if (null != parent) {
                parent.removeView(child);
                parent.addView(child, 0);
            }
        }
    }

    public class PuzzlePiece extends androidx.appcompat.widget.AppCompatImageView {
        public int xCoord;
        public int yCoord;
        public int pieceWidth;
        public int pieceHeight;
        public boolean canMove = true;

        public PuzzlePiece(Context context) {
            super(context);
        }
    }
}