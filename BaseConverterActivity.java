package com.racheli.baseconverter;
/**********************************************************************************************************
 *The BaseConverterActivity.java class and implement the functionality of the application.
 Required functionality - clicking on the button will convert the number that appears in the first text box
 to the base number in the second box, and will display the conversion result in the label under the button.
 If one of the text fields is blank, we will receive an error message stating that all information must be entered.
 If the number to convert is not a positive integer, you will receive an error message.
 If the base of the conversion is not in the 2-36 field, you will receive an error message.
 All error messages sent to Toast.
 **********************************************************************************************************/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BaseConverterActivity extends AppCompatActivity {

    private TextView lblResult;     //Variable type TesxtView  That represented the result on the screen
    private Button cmdClick;       //Variable type Button  That represented the button on the screen
    private EditText edtBaseID;   //Variable type EditText That represented the Base on the screen
    private EditText edtNumID;    //Variable type EditTextThat represented the number on the screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_base);


/***************************************************************************************
 * After defining variables for the screen elements,                                   *
 * we would like to link each variable to the component it represents on the screen.   *
 Each element defined in the layout has a unique id.                                   *
 You can get a pointer to a component using the findViewById method                    *
 of the Activity class, and returns a View object with the resulting id as a parameter.*
 ***************************************************************************************/
        lblResult=(TextView)findViewById(R.id.lblResult);
        cmdClick = (Button) findViewById(R.id.cmdClick);
        edtNumID = (EditText) findViewById(R.id.edtNumID);
        edtBaseID = (EditText) findViewById(R.id.edtBaseID);
/****************************************************************************************
 * (Listener) - The role of the department to wait for a specific event,                *
 * and when that happens, activate the method of the event.                             *
 A class functions as a listener by implementing a specific interface.                  *
 ***************************************************************************************/
        Listener lis = new Listener();
        cmdClick.setOnClickListener(lis);

    }

    private class Listener implements View.OnClickListener
    {

        public void onClick(View v)
        {
            String num = edtNumID.getText().toString();//Retrieving information from the screen
            String base = edtBaseID.getText().toString();
            if (num.equals("") || base.equals("")|| num.equals(null) || base.equals(null))
            {
                Toast.makeText(BaseConverterActivity.this,"Please enter a valid number and base",Toast.LENGTH_LONG).show();
            }
            else
            {
                int number = Integer.parseInt(num); //Converts a string to a natural number
                int theBase = Integer.parseInt(base);

                if ((theBase < 2) || (theBase > 36))
                {
                    Toast.makeText(BaseConverterActivity.this, "The number base should be in the given range", Toast.LENGTH_LONG).show();
                }
                else if (number < 0)
                {
                    Toast.makeText(BaseConverterActivity.this, "The number should be positive", Toast.LENGTH_LONG).show();
                }
                else
                {
                    lblResult.setText(BaseConverter.convertFrom10(number, theBase));
                }
            }
        }
    }
}
