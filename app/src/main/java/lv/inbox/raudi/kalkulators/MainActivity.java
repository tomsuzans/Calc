package lv.inbox.raudi.kalkulators;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {
    Button btnMS,btnMR,btnMC,btnClear,btnDivide,btn7,btn8,btn9,btnMultiply,btn4,btn5,btn6,btnSubtract,btn1,btn2,btn3,btnDecimal,btn0,btnEquals,btnSumm;
    TextView screen, result;

    double calcResult;
    boolean isNr1Empty = true;
    String operator;
    boolean error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.txtVwScreen);
        result = findViewById(R.id.txtVwResult);
        final StringBuilder screenOutput = new StringBuilder();

        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (error){
                    screen.setText("");
                    result.setText("");
                    calcResult = 0;
                    screenOutput.setLength(0);
                    isNr1Empty = true;
                } else {
                    makeSceenOutput(screenOutput,btn0.getText().toString());
                    screen.setText(screenOutput.toString());
                }

            }
        });

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSceenOutput(screenOutput,btn1.getText().toString());
                screen.setText(screenOutput.toString());


            }
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makeSceenOutput(screenOutput,btn2.getText().toString());
                screen.setText(screenOutput.toString());
            }
        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSceenOutput(screenOutput,btn3.getText().toString());
                screen.setText(screenOutput.toString());
            }
        });

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSceenOutput(screenOutput,btn4.getText().toString());
                screen.setText(screenOutput.toString());
            }
        });

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSceenOutput(screenOutput,btn5.getText().toString());
                screen.setText(screenOutput.toString());
                //result.setText(conductCalculation(screenOutput,number1,number2));
            }
        });

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSceenOutput(screenOutput,btn6.getText().toString());
                screen.setText(screenOutput.toString());
            }
        });

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSceenOutput(screenOutput,btn7.getText().toString());
                screen.setText(screenOutput.toString());
            }
        });

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSceenOutput(screenOutput,btn8.getText().toString());
                screen.setText(screenOutput.toString());
            }
        });

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSceenOutput(screenOutput,btn9.getText().toString());
                screen.setText(screenOutput.toString());
            }
        });

        btnDecimal = findViewById(R.id.btnDecimal);
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSceenOutput(screenOutput,btnDecimal.getText().toString());
                screen.setText(screenOutput.toString());
            }
        });

        btnEquals = findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Character.isDigit(screenOutput.toString().charAt(screenOutput.toString().length() -1))) {
                    //makeSceenOutput(screenOutput, btnSumm.getText().toString());
                    screen.setText(screenOutput.toString());
                    if (isNr1Empty) {
                        makeSceenOutput(screenOutput,"");
                    } else {
                        if (conductCalcPrep(screenOutput)==0&&operator=="/"){
                            screen.setText("");
                            result.setText("");
                            calcResult = 0;
                            screenOutput.setLength(0);
                            isNr1Empty = true;
                        } else {
                            calcResult = conductCalculation(screenOutput, calcResult, operator);
                            isNr1Empty = true;
                            screen.setText(calcResult + "");
                            result.setText(screenOutput.toString());
                            screenOutput.setLength(0);
                            screenOutput.append(calcResult);
                        }
                    }
                }
                else {
                    makeSceenOutput(screenOutput,"");
                }
            }
        });

        btnSumm = findViewById(R.id.btnSumm);
        btnSumm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Character.isDigit(screenOutput.toString().charAt(screenOutput.toString().length() -1))) {
                    makeSceenOutput(screenOutput, btnSumm.getText().toString());
                    screen.setText(screenOutput.toString());
                    if (isNr1Empty) {
                        result.setText("");
                        calcResult = conductCalcPrep(screenOutput);
                        operator = "+";
                        isNr1Empty = false;
                    } else {
                        if (conductCalcPrep(screenOutput)==0&&operator=="/"){
                            screen.setText("");
                            result.setText("");
                            calcResult = 0;
                            screenOutput.setLength(0);
                            isNr1Empty = true;
                        } else {
                            calcResult = conductCalculation(screenOutput, calcResult, operator);
                            operator = "+";
                            result.setText(calcResult + "");
                        }
                    }
                }
                 else {
                    makeSceenOutput(screenOutput,"");
                }
            }
        });

        btnSubtract = findViewById(R.id.btnSubtract);
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Character.isDigit(screenOutput.toString().charAt(screenOutput.toString().length() -1))) {
                    makeSceenOutput(screenOutput, btnSubtract.getText().toString());
                    screen.setText(screenOutput.toString());
                    if (isNr1Empty) {
                        result.setText("");
                        calcResult = conductCalcPrep(screenOutput);
                        operator = "-";
                        isNr1Empty = false;
                    } else {
                        if (conductCalcPrep(screenOutput)==0&&operator=="/"){
                            screen.setText("");
                            result.setText("");
                            calcResult = 0;
                            screenOutput.setLength(0);
                            isNr1Empty = true;
                        } else {
                            calcResult = conductCalculation(screenOutput, calcResult, operator);
                            operator = "-";
                            result.setText(calcResult + "");
                        }
                    }
                }
                else {
                    makeSceenOutput(screenOutput,"");
                }
            }
        });

        btnMultiply = findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Character.isDigit(screenOutput.toString().charAt(screenOutput.toString().length() -1))) {
                    makeSceenOutput(screenOutput, btnMultiply.getText().toString());
                    screen.setText(screenOutput.toString());
                    if (isNr1Empty) {
                        result.setText("");
                        calcResult = conductCalcPrep(screenOutput);
                        operator = "*";
                        isNr1Empty = false;
                    } else {
                        if (conductCalcPrep(screenOutput)==0&&operator=="/"){
                            screen.setText("");
                            result.setText("");
                            calcResult = 0;
                            screenOutput.setLength(0);
                            isNr1Empty = true;
                        } else {
                            calcResult = conductCalculation(screenOutput, calcResult, operator);
                            operator = "*";
                            result.setText(calcResult + "");
                        }
                    }
                }
                else {
                    makeSceenOutput(screenOutput,"");
                }
            }
        });

        btnDivide = findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Character.isDigit(screenOutput.toString().charAt(screenOutput.toString().length() -1))) {
                    makeSceenOutput(screenOutput, btnDivide.getText().toString());
                    screen.setText(screenOutput.toString());
                    if (isNr1Empty) {
                        result.setText("");
                        calcResult = conductCalcPrep(screenOutput);
                        operator = "/";
                        isNr1Empty = false;
                    } else {
                        if (conductCalcPrep(screenOutput)==0&&operator=="/"){
                            screen.setText("");
                            result.setText("");
                            calcResult = 0;
                            screenOutput.setLength(0);
                            isNr1Empty = true;
                        } else {
                            calcResult = conductCalculation(screenOutput, calcResult, operator);
                            operator = "/";
                            result.setText(calcResult + "");
                        }
                    }
                }
                else {
                    makeSceenOutput(screenOutput,"");
                }
            }
        });

        btnMS = findViewById(R.id.btnMS);
        btnMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveResInMem(v);
            }
        });

        btnMR = findViewById(R.id.btnMR);
        btnMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSceenOutput(screenOutput,readResFromMem(v));
                screen.setText(screenOutput.toString());
            }
        });

        btnMC = findViewById(R.id.btnMC);
        btnMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dir = getFilesDir();
                File file = new File(dir, "/savedValue");
                boolean deleted = file.delete();

            }
        });

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                result.setText("");
                calcResult = 0;
                screenOutput.setLength(0);
                isNr1Empty = true;
            }
        });
    }

    public StringBuilder makeSceenOutput (StringBuilder outputString, String stringToAdd){
         outputString.append(stringToAdd).toString();
        return outputString;
    }
    public double conductCalcPrep(StringBuilder currentScreenOutput){
        String newString;
        if (currentScreenOutput.toString().contains("+")){
           String [] temp = currentScreenOutput.toString().split("\\+");
           newString = temp[temp.length-1];
        }else {
            newString= currentScreenOutput.toString();
        }
        String[] arrOfStr = newString.split("[-*/]+");

        return Double.parseDouble(arrOfStr[arrOfStr.length-1]);
    }

    public double conductCalculation(StringBuilder stringWithNrToCalculate, double oldCalc, String operator){
        switch(operator) {
            case "-":
                return oldCalc - conductCalcPrep(stringWithNrToCalculate);
            case "*":
                return oldCalc * conductCalcPrep(stringWithNrToCalculate);
            case "/":
                return oldCalc / conductCalcPrep(stringWithNrToCalculate);
            default:
                return oldCalc + conductCalcPrep(stringWithNrToCalculate);
        }
    }

    public void saveResInMem (View view){
        String resultToSave = screen.getText().toString();
        FileOutputStream saveStream = null;
        try {
            saveStream = openFileOutput("savedValue", MODE_PRIVATE);
            saveStream.write(resultToSave.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if (saveStream!=null){
                try {
                    saveStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

    public String readResFromMem (View view){
        FileInputStream readStream = null;
        StringBuilder savedResBuilder = new StringBuilder();
        try {
            readStream = openFileInput( "savedValue");
            InputStreamReader inputStreamReader = new InputStreamReader(readStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String savedResult;
            while ((savedResult = bufferedReader.readLine())!=null){
                savedResBuilder.append(savedResult);//.append("\n");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if (readStream != null){
                try {
                    readStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return savedResBuilder.toString();
    }
}
