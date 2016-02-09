package es.rufflecol.lara.sortingintegers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_LEFT = "left";
    private static final String KEY_MIDDLE = "middle";
    private static final String KEY_RIGHT = "right";

    private int intLeft;
    private int intMiddle;
    private int intRight;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_LEFT, intLeft);
        savedInstanceState.putInt(KEY_MIDDLE, intMiddle);
        savedInstanceState.putInt(KEY_RIGHT, intRight);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        intLeft = savedInstanceState.getInt(KEY_LEFT);
        intMiddle = savedInstanceState.getInt(KEY_MIDDLE);
        intRight = savedInstanceState.getInt(KEY_RIGHT);
        sortIntegers();
    }

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

                intLeft = Integer.parseInt(stringLeft);
                intMiddle = Integer.parseInt(stringMiddle);
                intRight = Integer.parseInt(stringRight);

                sortIntegers();

                integerLeftEditText.getText().clear();
                integerMiddleEditText.getText().clear();
                integerRightEditText.getText().clear();
            }
        });
    }

    private void sortIntegers() {

        TextView displaySortedResult = (TextView) findViewById(R.id.display_result);

        if ((intLeft < intMiddle) && (intLeft < intRight) && (intMiddle < intRight)) {
            displaySortedResult.setText(intLeft + "\n" + intMiddle + "\n" + intRight);
        } else if ((intLeft < intMiddle) && (intLeft < intRight) && (intMiddle > intRight)) {
            displaySortedResult.setText(intLeft + "\n" + intRight + "\n" + intMiddle);
        } else if ((intMiddle < intLeft) && (intMiddle < intRight) && (intLeft < intRight)) {
            displaySortedResult.setText(intMiddle + "\n" + intLeft + "\n" + intRight);
        } else if ((intRight < intLeft) && (intLeft < intMiddle) && (intMiddle > intRight)) {
            displaySortedResult.setText(intRight + "\n" + intLeft + "\n" + intMiddle);
        } else if ((intMiddle < intLeft) && (intMiddle < intRight) && (intLeft > intRight)) {
            displaySortedResult.setText(intMiddle + "\n" + intRight + "\n" + intLeft);
        } else if ((intRight < intLeft) && (intRight < intMiddle) && (intMiddle < intLeft)) {
            displaySortedResult.setText(intRight + "\n" + intMiddle + "\n" + intLeft);
        }
    }
}