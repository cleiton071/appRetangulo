package com.cleiton071.metrosquadrados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewHolder mViewHolder = new ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.alt = findViewById(R.id.editText_alt);
        this.mViewHolder.base = findViewById(R.id.editText_base);
        this.mViewHolder.calcular = findViewById(R.id.button_calcular);
        this.mViewHolder.result = findViewById(R.id.textView_result);
        this.mViewHolder.calcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calcular) {

            String h = this.mViewHolder.alt.getText().toString();
            String b = this.mViewHolder.base.getText().toString();

            if ("".equals(h) || "".equals(b)) {
                Toast.makeText(this, "preencha os dados!", Toast.LENGTH_LONG).show();
            } else {
                Double vAlt = Double.valueOf(h);
                Double vBase = Double.valueOf(b);

                this.mViewHolder.result.setText(String.format("%.2f", vAlt * vBase));
            }
        }
    }

    private static class ViewHolder {

        EditText alt;
        EditText base;
        Button calcular;
        TextView result;
    }
}