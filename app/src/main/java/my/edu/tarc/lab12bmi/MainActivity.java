package my.edu.tarc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    EditText etWeight;
    EditText etHeight;
    double bmi;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = (EditText)findViewById(R.id.weightInput);
        etHeight = (EditText)findViewById(R.id.heightInput);
        iv = (ImageView)findViewById(R.id.imageView);
    }

    public void calculate(View v){
        TextView result;
        result = (TextView)findViewById(R.id.textView);

        double weight = Double.parseDouble(etWeight.getText().toString());
        double height = Double.parseDouble(etHeight.getText().toString());
        bmi = weight/Math.pow(height,2);



        if(bmi<=18.5) {
            iv.setImageResource(R.drawable.under);
            result.setText(getString(R.string.result) + ": " + String.format("%.2f", bmi) + " (" + getString(R.string.underw) + ")" );
        }
        else if(bmi>=22.5) {
            iv.setImageResource(R.drawable.over);
            result.setText(getString(R.string.result) + ": " + String.format("%.2f", bmi) + " (" + getString(R.string.overw) + ")"  );
        }
        else {
            iv.setImageResource(R.drawable.normal);
            result.setText(getString(R.string.result) + ": " + String.format("%.2f", bmi)  + " (" + getString(R.string.normalw) + ")" );
        }
    }

    public void reset(View v){
        iv.setImageResource(R.drawable.empty);
        etWeight.setText("");
        etHeight.setText("");
    }


}
