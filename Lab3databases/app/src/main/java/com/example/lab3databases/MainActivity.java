package com.example.lab3databases;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView productId;
    EditText productName, productPrice;
    Button addBtn, findBtn, deleteBtn;
    ListView productListView;

    ArrayList<String> productList;
    ArrayAdapter<String> adapter;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();

        // info layout
        productId = findViewById(R.id.productId);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);

        // buttons
        addBtn = findViewById(R.id.addBtn);
        findBtn = findViewById(R.id.findBtn);
        deleteBtn = findViewById(R.id.deleteBtn);

        // listview
        productListView = findViewById(R.id.productListView);

        // db handler
        dbHandler = new MyDBHandler(this);

        // ADD product button
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = productName.getText().toString().trim();
                String priceText = productPrice.getText().toString().trim();

                if (name.isEmpty() || priceText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter both name and price", Toast.LENGTH_SHORT).show();
                    return;
                }

                double price = Double.parseDouble(priceText);
                Product product = new Product(name, price);
                dbHandler.addProduct(product);

                productName.setText("");
                productPrice.setText("");

                viewProducts();
            }
        });

        // FIND product button
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = productName.getText().toString().trim();
                String priceText = productPrice.getText().toString().trim();
                Double price = priceText.isEmpty() ? null : Double.parseDouble(priceText);

                productList.clear();
                Cursor cursor = dbHandler.findProduct(name, price);
                if (cursor.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No matching products", Toast.LENGTH_SHORT).show();
                } else {
                    while (cursor.moveToNext()) {
                        productList.add(cursor.getString(1) + " (" + cursor.getString(2) + ")");
                    }
                }

                adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, productList);
                productListView.setAdapter(adapter);
            }
        });

        // DELETE product button
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = productName.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter a product name to delete", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.deleteProduct(name);
                Toast.makeText(MainActivity.this, "Deleted product(s) named " + name, Toast.LENGTH_SHORT).show();

                productName.setText("");
                productPrice.setText("");

                viewProducts();
            }
        });

        // Show all products when app opens
        viewProducts();
    }

    private void viewProducts() {
        productList.clear();
        Cursor cursor = dbHandler.getData();
        if (cursor.getCount() == 0) {
            Toast.makeText(MainActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                productList.add(cursor.getString(1) + " (" + cursor.getString(2) + ")");
            }
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productList);
        productListView.setAdapter(adapter);
    }
}
