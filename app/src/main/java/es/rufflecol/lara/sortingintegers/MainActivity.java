package es.rufflecol.lara.sortingintegers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sortButton = (Button) findViewById(R.id.sort_button);
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText integerLeftEditText = (EditText) findViewById(R.id.integer_input_left);
                String stringLeft = integerLeftEditText.getText().toString();

                EditText integerMiddleEditText = (EditText) findViewById(R.id.integer_input_middle);
                String stringMiddle = integerMiddleEditText.getText().toString();

                EditText integerRightEditText = (EditText) findViewById(R.id.integer_input_right);
                String stringRight = integerRightEditText.getText().toString();

                TextView displaySortedResult = (TextView) findViewById(R.id.display_result);

                int integerLeft = Integer.parseInt(stringLeft);
                int integerMiddle = Integer.parseInt(stringMiddle);
                int integerRight = Integer.parseInt(stringRight);

                if ((integerLeft < integerMiddle) && (integerLeft < integerRight) && (integerMiddle < integerRight)) {
                    displaySortedResult.setText(stringLeft + "\n" + stringMiddle + "\n" + stringRight);
                } else if ((integerLeft < integerMiddle) && (integerLeft < integerRight) && (integerMiddle > integerRight)) {
                    displaySortedResult.setText(stringLeft + "\n" + stringRight + "\n" + stringMiddle);
                } else if ((integerMiddle < integerLeft) && (integerMiddle < integerRight) && (integerLeft < integerRight)) {
                    displaySortedResult.setText(stringMiddle + "\n" + stringLeft + "\n" + stringRight);
                } else if ((integerRight < integerLeft) && (integerLeft < integerMiddle) && (integerMiddle > integerRight)) {
                    displaySortedResult.setText(stringRight + "\n" + stringLeft + "\n" + stringMiddle);
                } else if ((integerMiddle < integerLeft) && (integerMiddle < integerRight) && (integerLeft > integerRight)) {
                    displaySortedResult.setText(stringMiddle + "\n" + stringRight + "\n" + stringLeft);
                } else if ((integerRight < integerLeft) && (integerRight < integerMiddle) && (integerMiddle < integerLeft)) {
                    displaySortedResult.setText(stringRight + "\n" + stringMiddle + "\n" + stringLeft);
                }
            }
        });
    }
}