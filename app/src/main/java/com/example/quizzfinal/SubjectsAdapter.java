package com.example.quizzfinal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.Viewholider> {

    Context context;
    SendDataHome sendDataHome;
    List<Subjects> subjects;

    // contructer
    public SubjectsAdapter(Context context, List<Subjects> subjects, SendDataHome sendDataHome) {
        this.context = context;
        this.subjects = subjects;
        this.sendDataHome = sendDataHome;
    }

    // ánh xạ view
    @NonNull
    @Override
    public Viewholider onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view, parent, false);
        Viewholider viewHolder = new Viewholider(view);
        return viewHolder;
    }

    // get dữ liệu và xử lý view
    @Override
    public void onBindViewHolder(@NonNull Viewholider holder, @SuppressLint("RecyclerView") int position) {
        Subjects subject = subjects.get(position);

        holder.txtText.setText(subject.getName());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(subject.getImage()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    sendDataHome.send("hoa");
                } else if (position == 1) {
                    sendDataHome.send("vatly");
                } else if (position == 2) {
                    sendDataHome.send("sinhhoc");
                } else if (position == 3) {
                    sendDataHome.send("tienganh");
                }
            }
        });

    }

    // get dữ liệu
    @Override
    public int getItemCount() {
        return subjects.size();
    }

    // ánh xạ view
    class Viewholider extends RecyclerView.ViewHolder {
        TextView txtText;
        ImageView imageView;

        public Viewholider(@NonNull View itemView) {
            super(itemView);
            txtText = itemView.findViewById(R.id.textSubject);
            imageView = itemView.findViewById(R.id.imgImage);
        }
    }

}
