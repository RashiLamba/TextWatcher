package com.example.customlistview;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editTextSearch;
    String[] name = {"Burger", "Pasta", "Chaumin", "Nothing", "Burger", "Pasta", "Chaumin",
            "Nothing", "Burger", "Pasta", "Chaumin", "Nothing"};
    String[] description = {"i like king burger", "i like pasta", "i like chaumin", "I like nothibg",
            "i like king burger", "i like pasta", "i like chaumin", "I like nothibg", "i like king burger",
            "i like pasta", "i like chaumin", "I like nothibg"};
    Integer[] image = {R.drawable.ic_baseline_eco_24, R.drawable.ic_baseline_equalizer_24,
            R.drawable.ic_baseline_emoji_food_beverage_24, R.drawable.ic_baseline_fastfood_24,
            R.drawable.ic_baseline_eco_24, R.drawable.ic_baseline_equalizer_24,
            R.drawable.ic_baseline_emoji_food_beverage_24, R.drawable.ic_baseline_fastfood_24,
            R.drawable.ic_baseline_eco_24, R.drawable.ic_baseline_equalizer_24,
            R.drawable.ic_baseline_emoji_food_beverage_24, R.drawable.ic_baseline_fastfood_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        editTextSearch = findViewById(R.id.edit_text_search);

        Custom1 custom1 = new Custom1(this, name, description, image);
        listView.setAdapter(custom1);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(),"before text change",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                custom1.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(getApplicationContext(),"after text change",Toast.LENGTH_LONG).show();

            }
        });


    }


}