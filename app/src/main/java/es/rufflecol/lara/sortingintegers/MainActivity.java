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

                int intLeft = Integer.parseInt(stringLeft);
                int intMiddle = Integer.parseInt(stringMiddle);
                int intRight = Integer.parseInt(stringRight);

                if ((intLeft < intMiddle) && (intLeft < intRight) && (intMiddle < intRight)) {
                    displaySortedResult.setText(stringLeft + "\n" + stringMiddle + "\n" + stringRight);
                } else if ((intLeft < intMiddle) && (intLeft < intRight) && (intMiddle > intRight)) {
                    displaySortedResult.setText(stringLeft + "\n" + stringRight + "\n" + stringMiddle);
                } else if ((intMiddle < intLeft) && (intMiddle < intRight) && (intLeft < intRight)) {
                    displaySortedResult.setText(stringMiddle + "\n" + stringLeft + "\n" + stringRight);
                } else if ((intRight < intLeft) && (intLeft < intMiddle) && (intMiddle > intRight)) {
                    displaySortedResult.setText(stringRight + "\n" + stringLeft + "\n" + stringMiddle);
                } else if ((intMiddle < intLeft) && (intMiddle < intRight) && (intLeft > intRight)) {
                    displaySortedResult.setText(stringMiddle + "\n" + stringRight + "\n" + stringLeft);
                } else if ((intRight < intLeft) && (intRight < intMiddle) && (intMiddle < intLeft)) {
                    displaySortedResult.setText(stringRight + "\n" + stringMiddle + "\n" + stringLeft);
                }

                integerLeftEditText.getText().clear();  
                integerMiddleEditText.getText().clear();
                integerRightEditText.getText().clear();
            }
        });
    }
}