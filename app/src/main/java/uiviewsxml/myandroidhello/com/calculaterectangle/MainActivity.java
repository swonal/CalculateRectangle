package uiviewsxml.myandroidhello.com.calculaterectangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText length;
    private EditText width;
    private Button calButton;
    private Button clear;
    private TextView area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        width = (EditText) findViewById(R.id.editText1);
        length = (EditText) findViewById(R.id.editText2);
        area = (TextView) findViewById(R.id.textView5);
        calButton = (Button) findViewById(R.id.button1);
        clear = (Button) findViewById(R.id.button2);
        calButton.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String lengthString = length.getText().toString();
        String widthString = width.getText().toString();
        if (lengthString.isEmpty()&& widthString.isEmpty()) {
            switch (v.getId()) {
                case R.id.button1:
                    Toast.makeText(getApplicationContext(), "Enter Values", Toast.LENGTH_LONG).show();
                    break;
                case R.id.button2:
                    Toast.makeText(getApplicationContext(), "Already Cleared!", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        else if (lengthString.isEmpty()||widthString.isEmpty()){
            if(widthString.isEmpty()) {
                switch (v.getId()) {
                    case R.id.button1:
                        Toast.makeText(getApplicationContext(), "Enter Width Values", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button2:
                        clearInput();
                        break;
                }
            }
            else{
                switch (v.getId()) {
                    case R.id.button1:
                        Toast.makeText(getApplicationContext(), "Enter Length Values", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button2:
                        clearInput();
                        break;
                }
            }
        }
        else{
            try{
                switch(v.getId()){
                    case R.id.button1 : calc(lengthString, widthString);
                        break;
                    case R.id.button2 : clearInput();
                        break;
                }
            }
            catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(), "Enter a valid number", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void calc(String len, String wid){
        double lengthDou = Double.parseDouble(len);
        double widthDou = Double.parseDouble(wid);
        double areaDou = widthDou * lengthDou;
        String areaString = String.valueOf(areaDou);
        area.setText(areaString);
    }

    public void clearInput(){
        length.setText("");
        width.getText().clear();
        area.setText("");
        width.requestFocus();
        Toast.makeText(getApplicationContext(), "Input Cleared!", Toast.LENGTH_SHORT).show();
    }
}
