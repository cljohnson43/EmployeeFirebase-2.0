package com.example.employeefirebase.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeefirebase.R;
import com.example.employeefirebase.models.Employee;

public class EmployeesAdapter extends ListAdapter<Employee, EmployeesAdapter.EmployeeViewHolder> {
    public EmployeesAdapter() {
        super(EmployeesAdapter.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        Employee employee = getItem(position);
        holder.tvCompany.setText(employee.getmCompany());
        holder.tvName.setText(employee.getmName());
    }

    public static final DiffUtil.ItemCallback<Employee> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Employee>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull Employee oldEmployee, @NonNull Employee newEmployee) {
                    // Employee properties may have changed if reloaded from the DB, but ID is fixed
                    return oldEmployee.getmId() == newEmployee.getmId();
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull Employee oldEmployee, @NonNull Employee newEmployee) {
                    // NOTE: if you use equals, your object must properly override Object#equals()
                    // Incorrectly returning false here will result in too many animations.
                    return (oldEmployee.getmCompany().equals(newEmployee.getmCompany()))
                            && (oldEmployee.getmName().equals(newEmployee.getmName()));
                }
            };

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCompany;

        public EmployeeViewHolder(View view) {
            super(view);

            tvName = view.findViewById(R.id.tv_name);
            tvCompany = view.findViewById(R.id.tv_company);
        }
    }
}
