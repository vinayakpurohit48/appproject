package com.example.unknown_app;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizFragment extends Fragment {

    TextView Question;
    Button yes, no;
    private String questions[] = {
            "Java is an object-oriented programming language. (True/False)",
            "Java supports multiple inheritance. (True/False)",
            "Java has built-in garbage collection. (True/False)",
            "Java programs are compiled into machine code. (True/False)",
            "Java was developed by Microsoft. (True/False)",
            "Java is platform-independent. (True/False)",
            "Java code is executed from top to bottom without any conditional statements. (True/False)",
            "Java was released in the year 1995. (True/False)",
            "Java applications can only run on a web browser. (True/False)",
            "Java is a purely functional programming language. (True/False)"
    };
    private Boolean answers[] = {true, false, true, false, false, true, false, true, false, false};
    private Integer qno = 0;
    private Integer score = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        Question = view.findViewById(R.id.Question);
        yes = view.findViewById(R.id.yes);
        no = view.findViewById(R.id.no);

        Question.setText(questions[qno]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qno++;
                if (qno < questions.length) {
                    Question.setText(questions[qno]);
                    if (answers[qno - 1]) {
                        score++;
                    }
                } else {
                    Toast.makeText(getActivity(), "Your score is: " + score, Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qno++;
                if (qno < questions.length) {
                    Question.setText(questions[qno]);
                    if (!answers[qno - 1]) {
                        score++;
                    }
                } else {
                    Toast.makeText(getActivity(), "Your score is: " + score, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
