package com.example.hyunyoungpark.action;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;


public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {

    private static final String TAG = GreenAdapter.class.getSimpleName();
    private int mNumberItems;
    private static int viewHolderCount;
    final private ListItemClickListener onClickListener;

    public interface ListItemClickListener {
        void onListItemClick(int position);

    }


    public GreenAdapter(int numberOfItems, ListItemClickListener listener) {
        mNumberItems = numberOfItems;
        onClickListener = listener;
        viewHolderCount = 0;

    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        int bg = ColorUtils.getViewHolderBackgroundColorFromInstance(context, viewHolderCount);
        viewHolder.itemView.setBackgroundColor(bg);
        viewHolderCount++;

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);

    }

    @Override
    public int getItemCount() {

        return mNumberItems;
    }


    class NumberViewHolder extends RecyclerView.ViewHolder
            implements View.onClickListener {


        TextView listItemNumberView;


        public NumberViewHolder(View itemView) {
            super(itemView);

            listItemNumberView = (TextView) itemView.findViewById(R.id.tv_item_number);
            itemView.setOnClickListener((View.OnClickListener) this);


        }

        public void bind(int ListIndex) {

            listItemNumberView.setText(String.valueOf(ListIndex));
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            onClickListener.onListItemClick(position);
        }
    }
}





