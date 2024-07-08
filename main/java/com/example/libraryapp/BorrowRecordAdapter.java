package com.example.libraryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryapp.R;
import com.example.libraryapp.BorrowRecord;

import java.util.List;

public class BorrowRecordAdapter extends RecyclerView.Adapter<BorrowRecordAdapter.BorrowRecordViewHolder> {

    private final Context context;
    private final List<BorrowRecord> borrowRecords;

    public BorrowRecordAdapter(Context context, List<BorrowRecord> borrowRecords) {
        this.context = context;
        this.borrowRecords = borrowRecords;
    }

    @NonNull
    @Override
    public BorrowRecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_borrow_record, parent, false);
        return new BorrowRecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BorrowRecordViewHolder holder, int position) {
        BorrowRecord borrowRecord = borrowRecords.get(position);
        holder.nrpPeminjamTextView.setText("NRP Peminjam : " + borrowRecord.getNrpPeminjam());
        holder.bookIdTextView.setText(String.valueOf("ID Buku : " + borrowRecord.getBookId()));
        holder.borrowedAtTextView.setText("Dipinjam pada : " + borrowRecord.getBorrowedAt());
        holder.returnedAtTextView.setText("Dikembalikan pada : " + borrowRecord.getReturnedAt() );
    }

    @Override
    public int getItemCount() {
        return borrowRecords.size();
    }

    static class BorrowRecordViewHolder extends RecyclerView.ViewHolder {
        TextView nrpPeminjamTextView;
        TextView bookIdTextView;
        TextView borrowedAtTextView;
        TextView returnedAtTextView;

        BorrowRecordViewHolder(@NonNull View itemView) {
            super(itemView);
            nrpPeminjamTextView = itemView.findViewById(R.id.nrp_peminjam);
            bookIdTextView = itemView.findViewById(R.id.book_id);
            borrowedAtTextView = itemView.findViewById(R.id.borrowed_at);
            returnedAtTextView = itemView.findViewById(R.id.returned_at);
        }
    }
}
