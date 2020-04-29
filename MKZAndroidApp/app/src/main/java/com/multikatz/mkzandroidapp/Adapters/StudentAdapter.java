package com.multikatz.mkzandroidapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.multikatz.mkzandroidapp.Models.Student;
import com.multikatz.mkzandroidapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> dataList;
    private Context context;

    public StudentAdapter(Context context,List<Student> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView etxtFullName;
        TextView etxtEmail;
        private ImageView imgProfile;

        StudentViewHolder(View itemView) {

            super(itemView);
            mView = itemView;

            etxtFullName = mView.findViewById(R.id.etxtFullName);
            etxtEmail = mView.findViewById(R.id.etxtEmail);
            imgProfile = mView.findViewById(R.id.imgProfile);

        }
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {

        holder.etxtFullName.setText(dataList.get(position).getFullName());
        holder.etxtEmail.setText(dataList.get(position).getEmail());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getImage())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.imgProfile);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
