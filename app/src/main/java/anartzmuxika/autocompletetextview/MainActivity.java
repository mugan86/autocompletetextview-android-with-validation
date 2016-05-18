package anartzmuxika.autocompletetextview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    AutoCompleteTextView text, text2;

    TextView add_stateTextView;

    List<Mountain> langs = new ArrayList<>();

    Mountain mountain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        text=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        add_stateTextView = (TextView) findViewById(R.id.add_stateTextView);

        text.setThreshold(1);


        langs = retrieveMountain();

        final MountainArrayAdapter adapter = new MountainArrayAdapter(this, R.layout.activity_main, R.id.lbl_name, langs);
        text.setAdapter(adapter);

        text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String my_var = adapter.getItem(position).toString();
            }
        });
/**
 * Unset the var whenever the user types. Validation will
 * then fail. This is how we enforce selecting from the list.
 */
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mountain = new Mountain();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final String my_var = null;
            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("LENGHT: " + s.length());
            }

        });

        text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {


                if (!hasFocus) {
                    // code to execute when EditText loses focus
                    if (langs.contains(mountain)) {
                        System.out.println("Correct mountain!!!");
                        add_stateTextView.setText("Add correct mountain! :)");

                    } else {
                        System.out.println("No correct mountain...");
                        add_stateTextView.setText("No correct mountain! Please try again ;)");
                        text.setText("");
                        text.requestFocus();
                    }
                }
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String add_state_str = "";
                // code to execute when EditText loses focus
                if (langs.contains(mountain)) {
                    System.out.println("Correct mountain!!!");
                    add_state_str = "Add correct mountain! :)";
                    add_stateTextView.setText(add_state_str);

                } else {
                    System.out.println("No correct mountain...");
                    add_state_str = "No correct mountain! Please try again ;)";
                    add_stateTextView.setText(add_state_str);
                    text.setText("");
                    text.requestFocus();
                }

                Snackbar.make(view, add_state_str, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do whatever you want with the selected item
                Log.d("TAG", adapter.getItem(position).getName() + " has been selected!");
                mountain = adapter.getItem(position);

            }
        });


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
            openDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Mountain> retrieveMountain() {
        List<Mountain> list = new ArrayList<>();
        list.add(new Mountain("1", "Karakate"));
        list.add(new Mountain("2", "Kalamua"));
        list.add(new Mountain("3", "Urko"));
        list.add(new Mountain("4", "Akondia"));
        list.add(new Mountain("5", "Akelarre"));
        list.add(new Mountain("6", "Atxolin"));
        list.add(new Mountain("7", "Oiz"));
        list.add(new Mountain("8", "Gorbeia"));
        list.add(new Mountain("9", "Anboto"));
        return list;
    }

    private void openDialog()
    {
// get prompts.xml view
        LayoutInflater li = LayoutInflater.from(MainActivity.this);
        View promptsView = li.inflate(R.layout.comment_dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        text2=(AutoCompleteTextView) promptsView.findViewById(R.id.autoCompleteTextView2);

        final List<Mountain> langs = retrieveMountain();



        System.out.println("Mountains list: " + langs.size());



        final MountainArrayAdapter adapter = new MountainArrayAdapter(this, R.layout.row_mountain, R.id.lbl_name, langs);
        text2.setAdapter(adapter);

        text2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mountain = new Mountain();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final String my_var = null;
            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("LENGHT: " + s.length());
            }

        });

        text2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {


                if (!hasFocus) {
                    // code to execute when EditText loses focus
                    if (langs.contains(mountain)) {
                        System.out.println("Correct mountain!!!");

                    } else {
                        System.out.println("No correct mountain...");
                        text2.setText("");
                        text2.requestFocus();
                    }
                }
            }
        });

        text2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do whatever you want with the selected item
                Log.d("TAG", adapter.getItem(position).getName() + " has been selected!");
                mountain = adapter.getItem(position);

            }
        });

        // set dialog message
        alertDialogBuilder
                .setTitle("Title")
                .setCancelable(false);

        // create alert dialog
        final AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();

    }
}
