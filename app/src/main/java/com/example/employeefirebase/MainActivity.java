package com.example.employeefirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.employeefirebase.auth.FirebaseUIActivity;
import com.example.employeefirebase.models.Employee;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private final String EMPLOYEE_CHILD = "employees";

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    private DatabaseReference mDB;

    private Button btnSubmit;
    private EditText etName;
    private EditText etCompany;
    private RecyclerView rvEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        if (mFirebaseUser == null) {
            startActivity(new Intent(this, FirebaseUIActivity.class));
            finish();
        } else {
            Log.d("TAG_X", "user is logged in");
        }

        mDB = FirebaseDatabase.getInstance().getReference();

        rvEmployees = findViewById(R.id.rv_employees);
        etCompany = findViewById(R.id.et_company);
        etName = findViewById(R.id.et_name);

        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String company = etCompany.getText().toString();
                Employee employee = new Employee(name, company);

                mDB.child(EMPLOYEE_CHILD).push().setValue(employee);

                etName.getText().clear();
                etCompany.getText().clear();

                Toast.makeText(getBaseContext(), "Employee added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
