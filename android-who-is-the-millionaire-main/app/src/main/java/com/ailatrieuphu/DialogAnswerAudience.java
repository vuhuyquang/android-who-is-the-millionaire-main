package com.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class DialogAnswerAudience extends Dialog {
    public DialogAnswerAudience(Context context, int loca, ArrayList<TextView> arrTxvCauTraLoi, boolean support_5050, String type) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.help_from_the_audience);
        TextView txvChonA,txvChonB,txvChonC,txvChonD, txt_title;
        Random r = new Random();
        int arrdrom[] = new int[]{0,0,0,0};
        int arrPhanTranTl[] = new int[]{0,0,0,0}; // a  b  c d

        txvChonA = findViewById(R.id.txvChonA);
        txvChonB = findViewById(R.id.txvChonB);
        txvChonC = findViewById(R.id.txvChonC);
        txvChonD = findViewById(R.id.txvChonD);
        txt_title = findViewById(R.id.txt_title);

        if(type == "support_call"){
            txt_title.setText(("Câu trả lời của người thân là: ").toString());
            int value_random = r.nextInt(100);

            if(value_random >=50){
                txvChonB.setText((getLocation(loca)).toString());
            }else{
                int fail_value_random = 0;
                do {
                    fail_value_random=r.nextInt(4);
                }while (fail_value_random == loca);
                txvChonB.setText((getLocation(r.nextInt(3))).toString());
            }

            txvChonA.setText(("").toString());
            txvChonC.setText(("").toString());
            txvChonD.setText(("").toString());
        }else{

            int soKhanGia = 200;
            int can = 25;

            for(int i=0;i<arrdrom.length;i++){
                if(support_5050){
                    arrdrom[i]=arrdrom[i]+can;// 25 50 100 125
                    if(i==loca-1){
                        arrdrom[i]=arrdrom[i]+25; // 25 50 100
                        can = can+25;//100
                    }
                    can = can+25;//can 125
                }else{
                    TextView t = arrTxvCauTraLoi.get(i);
                    if(t.getVisibility() == View.INVISIBLE){
                        arrdrom[i] = 0;
                    }else{
                        arrdrom[i]=50;
                        if(i==loca-1){
                            arrdrom[i]=125;
                        }
                    }
                }


            }

            int tong = 125;

            for(int i=0;i<soKhanGia;i++){
                int chon = r.nextInt(tong);// 0 25 75 100 125
                if(chon>=0 && chon<arrdrom[0]){
                    arrPhanTranTl[0]++;
                }else if(chon>= arrdrom[0] && chon<arrdrom[1]){
                    arrPhanTranTl[1]++;
                }else if(chon>= arrdrom[1] && chon<arrdrom[2]){
                    arrPhanTranTl[2]++;
                }else {
                    arrPhanTranTl[3]++;
                }
            }

            txvChonA.setText("A : "+(int)(arrPhanTranTl[0]*100.0f/soKhanGia)+" %");
            txvChonB.setText("B : "+(int)(arrPhanTranTl[1]*100.0f/soKhanGia)+" %");
            txvChonC.setText("C : "+(int)(arrPhanTranTl[2]*100.0f/soKhanGia)+" %");
            txvChonD.setText("D : "+(int)(arrPhanTranTl[3]*100.0f/soKhanGia)+" %");
        }


    }

    private String getLocation (int loca){
        return (loca == 1 ? "A" : loca == 2 ? "B": loca == 3 ? "C":"D").toString();
    }
}
