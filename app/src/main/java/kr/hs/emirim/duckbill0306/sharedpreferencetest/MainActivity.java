package kr.hs.emirim.duckbill0306.sharedpreferencetest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editName,editAge;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //activity가 처음 시작 하였을 때 실행!
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=(EditText)findViewById(R.id.edit_name);
        editAge=(EditText)findViewById(R.id.edit_age);

        sp=getSharedPreferences("appInfo", Context.MODE_PRIVATE);// (문서 이름, private)

    }

    @Override
    protected void onResume() { //다시 나타날 때 호출(화면에 보여줌!)
        super.onResume();
        String name=sp.getString("name","");
        String age=sp.getString("age","");//name을 가져와라! 없으면 공백!
        editName.setText(name);
        editAge.setText(age);
    }

    @Override
    protected void onStop() { // 사라질 때 호출
        super.onStop();
        String name=sp.getString("age","");
        SharedPreferences.Editor edit=sp.edit(); //edit의 참조값을 반환 받음!
        edit.putString("name",editName.getText().toString());//editName에 입력된 값을 name에 저장 한다! (String형으로)
        edit.putString("age",editAge.getText().toString());
        edit.commit(); // commit을 꼭! 해주어야 실행 된다!!
    }
}
