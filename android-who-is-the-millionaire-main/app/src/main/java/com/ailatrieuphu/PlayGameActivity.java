package com.ailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ailatrieuphu.adapter.MoneyRewardAdapter;
import com.ailatrieuphu.object.Answer;
import com.ailatrieuphu.object.FaceData;

import java.util.ArrayList;
import java.util.Random;

public class PlayGameActivity extends AppCompatActivity {
    ListView money_list;
    MoneyRewardAdapter moneyRewardAdapter;
    ArrayList<String> arrMoneyRewar;
    Answer answer;

    int locaQuestionIndex = 1;
    View.OnClickListener listener;
    TextView box_question_txt, answer_text_A, answer_text_B, answer_text_C, answer_text_D, txvThuaGame, cancelEventClick, txt_numLocation;
    ImageView supportAudience,support5050, changeNewQuestion, supportCall;
    ArrayList<TextView> arrTxtAnswer;
    String cauTraoLoi;
    FaceData faceData;
    boolean support_5050 = true, support_answer_audience = true;;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        init();
        bindId();
        setUp();
        setClick();
    }

    public void init() {
        //create list money reward
        arrMoneyRewar = new ArrayList<>();
        arrMoneyRewar.add("11.000.000");
        arrMoneyRewar.add("50.00.000");
        arrMoneyRewar.add("2.500.000");
        arrMoneyRewar.add("125.000");
        arrMoneyRewar.add("64.000");
        arrMoneyRewar.add("32.000");
        arrMoneyRewar.add("16.000");
        arrMoneyRewar.add("8.000");
        arrMoneyRewar.add("4.000");
        arrMoneyRewar.add("2.000");
        arrMoneyRewar.add("1.000");
        arrMoneyRewar.add("500");
        arrMoneyRewar.add("300");
        arrMoneyRewar.add("200");
        arrMoneyRewar.add("100");

        moneyRewardAdapter = new MoneyRewardAdapter(this, 0, arrMoneyRewar);

        answer = new Answer();

        arrTxtAnswer = new ArrayList<>();

        faceData = new FaceData();
    }

    public void bindId() {
        money_list = findViewById(R.id.money_list);
        box_question_txt = findViewById(R.id.box_question_txt);
        answer_text_A = findViewById(R.id.answer_text_A);
        answer_text_B = findViewById(R.id.answer_text_B);
        answer_text_C = findViewById(R.id.answer_text_C);
        answer_text_D = findViewById(R.id.answer_text_D);
        txt_numLocation = findViewById(R.id.txt_numLocation);
        txvThuaGame = findViewById(R.id.txvThuaGame);
        cancelEventClick = findViewById(R.id.gone_clearEnventClick);
        supportAudience = findViewById(R.id.supportAudience);
        support5050 = findViewById(R.id.support5050);
        changeNewQuestion = findViewById(R.id.changeNewQuestion);
        supportCall = findViewById(R.id.supportCall);

        arrTxtAnswer.add(answer_text_A);
        arrTxtAnswer.add(answer_text_B);
        arrTxtAnswer.add(answer_text_C);
        arrTxtAnswer.add(answer_text_D);
    }

    public void setUp() {
        txvThuaGame.setVisibility(View.GONE);
        cancelEventClick.setVisibility(View.GONE);
        money_list.setAdapter(moneyRewardAdapter);
        changeNewQuestion.setVisibility(View.GONE);
        showQuestion();
    }

    public void setClick() {

        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(((TextView) view));
            }
        };
        for (TextView t : arrTxtAnswer) {
            t.setOnClickListener(listener);
        }
    }

    public void checkAnswer(final TextView txv) {
        cauTraoLoi = txv.getText().toString();
        txv.setBackgroundResource(R.drawable.bg_cau_chon);
        cancelEventClick.setVisibility(View.VISIBLE); // status show

        new CountDownTimer(2000, 100) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                for (TextView t : arrTxtAnswer) {
                    String s = t.getText().toString();
                    if (s.equals(answer.getDapAnDung())) {
                        t.setBackgroundResource(R.drawable.bg_cau_dung);
                        break;
                    }
                }
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        if (cauTraoLoi.equals(answer.getDapAnDung())) {
                            locaQuestionIndex++;
                            if (locaQuestionIndex > 15) {
                                locaQuestionIndex = 15;
                                txvThuaGame.setVisibility(View.VISIBLE);
                                txvThuaGame.setText("Chúc mừng bạn đã nhận được \n" + arrMoneyRewar.get(0) + "000 USD");
                                backActivityMain();
                                return;
                            }
                            cancelEventClick.setVisibility(View.INVISIBLE);// status hidden
                            showQuestion();
                            if(locaQuestionIndex == 6)changeNewQuestion.setVisibility(View.VISIBLE);
                        } else {
                            txvThuaGame.setVisibility(View.VISIBLE);
                            // 8 5
                            if(locaQuestionIndex == 1){
                                txvThuaGame.setText("Bạn sẽ ra về với tiền thưởng là \n" +"0 USD");
                            }else{
                                int vitriTienThuong = (locaQuestionIndex / 5) * 5;
                                txvThuaGame.setText("Bạn sẽ ra về với tiền thưởng là \n" + arrMoneyRewar.get(14 - vitriTienThuong) + "000 USD");

                            }
                            backActivityMain();
                            return;
                        }

                    }
                }.start();
            }

        }.start();

    }

    public void setQuestion() {
        answer = faceData.setQuestion(locaQuestionIndex, answer.getIdQuestion());
    }

    public void showQuestion() {
        setQuestion();
        txt_numLocation.setText(("Câu hỏi số " + locaQuestionIndex).toString());
        box_question_txt.setText(answer.getNoiDung());
        ArrayList<String> arrCauTraLoi = new ArrayList<>(answer.getArrDapAnSai());
        arrCauTraLoi.add(answer.getDapAnDung());

        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int vt1 = r.nextInt(arrCauTraLoi.size());
            int vt2 = r.nextInt(arrCauTraLoi.size());
            String a = arrCauTraLoi.get(vt1);// 0 1 2 3
            arrCauTraLoi.set(vt1, arrCauTraLoi.get(vt2));
            arrCauTraLoi.set(vt2, a);
        }

        for (int i = 0; i < arrTxtAnswer.size(); i++) {
            arrTxtAnswer.get(i).setOnClickListener(listener);
            arrTxtAnswer.get(i).setVisibility(View.VISIBLE);
            arrTxtAnswer.get(i).setBackgroundResource(R.drawable.bg_btn);
            arrTxtAnswer.get(i).setText(arrCauTraLoi.get(i));
        }

        moneyRewardAdapter.setViTriCauHoi(locaQuestionIndex);
    }


    public void support5050(View view) {
        if(support_5050 == false){
            return;
        }
        Random r= new Random();
        int sodanAnAnDi =2;
        do{
            int vitriDanAnAn = r.nextInt(4);// 1
            TextView t = arrTxtAnswer.get(vitriDanAnAn);

            if(t.getVisibility() == View.VISIBLE && t.getText().toString().equals(answer.getDapAnDung())==false){
                t.setVisibility(View.INVISIBLE);
                t.setOnClickListener(null);
                sodanAnAnDi --;
            }
        }while (sodanAnAnDi>0);
        support5050.setColorFilter(0xA3000000);
        support_5050 = false;
    }


    public void onSupportAnswerAudience(View view) {
        if (support_answer_audience == false){
            return;
        }

        supportAudience.setColorFilter(0xFF415761);
        for (int i=0;i<arrTxtAnswer.size();i++){
            TextView t = arrTxtAnswer.get(i);
            if(t.getVisibility() == View.VISIBLE && t.getText().toString().equals(answer.getDapAnDung())){
                new DialogAnswerAudience(this,i+1, arrTxtAnswer,support_5050, "support_audience").show();
                break;
            }
        }
        support_answer_audience =false;
    }

    boolean supportChangeQuestion = false;
    public void onChangeNewQuestion(View view) {
        if(supportChangeQuestion == false){
            return;
        }
        showQuestion();
        changeNewQuestion.setColorFilter(0xFF415761);
        supportChangeQuestion =false;
    }

    boolean isSupportCall = true;
    public void onSupportCall(View view) {
        if(isSupportCall == false){
            return;
        }
        for (int i=0;i<arrTxtAnswer.size();i++){
            TextView t = arrTxtAnswer.get(i);
            if(t.getVisibility() == View.VISIBLE && t.getText().toString().equals(answer.getDapAnDung())){
                new DialogAnswerAudience(this,i+1, arrTxtAnswer,support_5050,"support_call").show();
                break;
            }
        }
        supportCall.setColorFilter(0xA3000000);
        isSupportCall =false;
    }

    public void backActivityMain (){
        Intent intent = new Intent(this, MainActivity.class);
        new CountDownTimer(1500,100){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(intent);
            }
        }.start();

    }

}