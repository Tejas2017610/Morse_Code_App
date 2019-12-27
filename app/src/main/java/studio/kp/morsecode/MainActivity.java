package studio.kp.morsecode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private static TextView output,error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button submit;
        final EditText input;
        final TextView title;

        submit = findViewById(R.id.convertButton);
        input = findViewById(R.id.text);
        title = findViewById(R.id.title);
        output = findViewById(R.id.morseCode);
        error = findViewById(R.id.specialError);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final boolean b = Pattern.matches("[a-zA-Z0-9 ]*", input.getText().toString());
                String text = input.getText().toString();
                if(b){
                    String s = input.getText().toString().toLowerCase();
                    morsecode(s);
                    title.setVisibility(View.VISIBLE);
                    submit.setClickable(false);




                }
                else{
                    error.setVisibility(View.VISIBLE);
                    input.setError("Special characters are not used in Morse Code");
                }



            }
        });



    }



    public static void morsecode(String s){
        error.setVisibility(View.INVISIBLE);
        for (int i = 0;i<s.length(); i++){

//            morseEncode(s.charAt(i));
            output.append(morseEncode(s.charAt(i))+" ");


        }
    }
    public static String morseEncode(char x)
    {

        // refer to the Morse table
        // image attached in the article
        switch (x)
        {
            case 'a':
                return ".-";
            case 'b':
                return "-...";
            case 'c':
                return "-.-.";
            case 'd':
                return "-..";
            case 'e':
                return ".";
            case 'f':
                return "..-.";
            case 'g':
                return "--.";
            case 'h':
                return "....";
            case 'i':
                return "..";
            case 'j':
                return ".---";
            case 'k':
                return "-.-";
            case 'l':
                return ".-..";
            case 'm':
                return "--";
            case 'n':
                return "-.";
            case 'o':
                return "---";
            case 'p':
                return ".--.";
            case 'q':
                return "--.-";
            case 'r':
                return ".-.";
            case 's':
                return "...";
            case 't':
                return "-";
            case 'u':
                return "..-";
            case 'v':
                return "...-";
            case 'w':
                return ".--";
            case 'x':
                return "-..-";
            case 'y':
                return "-.--";
            // for space
            case 'z':
                return "--..";
            case ' ':
                    return "   ";
        }
        return "";
    }

}




