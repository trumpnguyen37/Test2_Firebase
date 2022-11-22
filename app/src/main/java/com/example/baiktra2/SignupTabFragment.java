package com.example.baiktra2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignupTabFragment extends Fragment {

    EditText email, number, pass , name ;
    Button signup;
    float v=0;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        email = root.findViewById(R.id.email1);
        pass = root.findViewById(R.id.pass1);
        number = root.findViewById(R.id.number);
        name = root.findViewById(R.id.fullname);
        signup = root.findViewById(R.id.btn_Signup);

        email.setTranslationX(800);
        pass.setTranslationX(800);
        number.setTranslationX(800);
        name.setTranslationX(800);
        signup.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        number.setAlpha(v);
        name.setAlpha(v);
        signup.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(550).start();
        number.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        name.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        signup.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = email.getText().toString().trim();
                String sdt = number.getText().toString().trim();
                String mk = pass.getText().toString().trim();
                String ten = name.getText().toString().trim();

                if (taikhoan.isEmpty()){
                    email.setError("Vui lòng nhập tài khoản!");
                    email.requestFocus();
                    return;
                }

                if (sdt.isEmpty()){
                    number.setError("Vui lòng nhập SĐT!");
                    email.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(taikhoan).matches()){
                    email.setError("Vui lòng nhập tài khoản dạng email!");
                    email.requestFocus();
                    return;
                }

                if (mk.isEmpty()){
                    pass.setError("Vui lòng nhập mật khẩu!");
                    pass.requestFocus();
                    return;
                }

                if (ten.isEmpty()){
                    name.setError("Vui lòng nhập tên của bạn!");
                    name.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(taikhoan,mk)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    startActivity(new Intent(getActivity(),MainActivity.class));
                                    Toast.makeText(getActivity(), "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(getActivity(), "Tạo tài khoản thất bại! "+task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        return root;
    }


}
