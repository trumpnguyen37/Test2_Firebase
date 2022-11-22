package com.example.baiktra2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {
    EditText Editname, EditscienceName, Editnature, EditleafColor;
    Button them;
    DatabaseReference databaseReference;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Editname = findViewById(R.id.etName);
        EditscienceName = findViewById(R.id.etScienceName);
        Editnature = findViewById(R.id.etNature);
        EditleafColor = findViewById(R.id.etLeafColor);
        them = findViewById(R.id.themBTN);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Editname.getText().toString();
                String scienceName = EditscienceName.getText().toString();
                String nature = Editnature.getText().toString();
                String leafColor = EditleafColor.getText().toString();

                Tree tree = new Tree(name, scienceName, nature, leafColor);

                database.getReference("Tree").push().setValue(tree).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(AddActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        });
    }
}