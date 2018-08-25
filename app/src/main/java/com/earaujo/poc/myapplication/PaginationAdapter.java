package com.earaujo.poc.myapplication;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int ITEM = 0;
    private static final int LOADING = 1;

    private List<Brand> brandList;
    private Context context;

    private boolean isLoadingAdded = false;

    public PaginationAdapter(Context context) {
        this.context = context;
        brandList = new ArrayList<>();
    }

    public List<Brand> getMovies() {
        return brandList;
    }

    public void setMovies(List<Brand> brandResults) {
        this.brandList = brandResults;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, inflater);
                break;
        }
        return viewHolder;
    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.item_list_brands, parent, false);
        viewHolder = new BrandVH(v1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final BrandVH brandVH = (BrandVH) holder;
        Brand brand = brandList.get(position);
    }

    @Override
    public int getItemCount() {
        return brandList == null ? 0 : brandList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == brandList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }


    /*
   Helpers
   _________________________________________________________________________________________________
    */

    public void add(Brand r) {
        brandList.add(r);
        notifyItemInserted(brandList.size() - 1);
    }

    public void addAll(List<Brand> moveResults) {
        for (Brand result : moveResults) {
            add(result);
        }
    }

    public void remove(Brand r) {
        int position = brandList.indexOf(r);
        if (position > -1) {
            brandList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Brand());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = brandList.size() - 1;
        Brand result = getItem(position);

        if (result != null) {
            brandList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public Brand getItem(int position) {
        return brandList.get(position);
    }

    public void updateItem(Brand brand, int position) {
        brandList.set(position, brand);
        notifyItemChanged(position);
    }

    public void setItemLoading(int position) {
        brandList.get(position).setFollowing(3);
        notifyDataSetChanged();
    }

    private void setSupportedBackground(int drawable, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(context.getResources().getDrawable(drawable));
        } else {
            view.setBackgroundDrawable(context.getResources().getDrawable(drawable));
        }
    }


   /*
   View Holders
   _________________________________________________________________________________________________
    */

    /**
     * Main list's content ViewHolder
     */
    protected class BrandVH extends RecyclerView.ViewHolder {
        private ImageView mBrandIcon;
        private TextView mBrandName;
        private ImageView mCartImg;
        private TextView mBtnFollow;
        private ProgressBar progressBar;

        public BrandVH(View itemView) {
            super(itemView);

            mBrandIcon = itemView.findViewById(R.id.imageViewBrandIcon);
            mBrandName = itemView.findViewById(R.id.textViewBrandName);
            mCartImg = itemView.findViewById(R.id.imageViewAddToChart);
            mBtnFollow = itemView.findViewById(R.id.buttonFollow);
        }
    }

    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }


}