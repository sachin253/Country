package com.example.country.Adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.example.country.MainActivity;
import com.example.country.Modle.Country;
import com.example.country.Modle.Language;
import com.example.country.Modle.Utils;
import com.example.country.R;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>
{
    private Country[] countries;
    private Context context;
    private Activity activity;

    public RvAdapter(Context context, Country[] countries, Activity activity)
    {

        this.countries = countries;
        this.context=context;
        this.activity=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_view_item,parent,false);
        return new RvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
         Country user= countries[position];
        try {
            holder.Name.setText(user.getName());
           String url_detail_img = user.getFlag();
            Uri myUri = Uri.parse(url_detail_img);

            Utils.fetchSvg(activity, url_detail_img, holder.post);
            holder.Capital.setText(user.getCapital());
            holder.Region.setText(user.getRegion());
            holder.SubRegion.setText(user.getSubregion());
            holder.Population.setText(user.getPopulation().toString());

            List<String> Bor= user.getBorders();
            String Con="";
            for(String s:Bor)
            {
                Con=Con+s+",";
            }
            holder.Borders.setText(Con);

            List<Language> Lang= user.getLanguages();
            String Con1="";
            for(Language s:Lang)
            {

                Con1+=s.getName()+",";


            }
            holder.Languages.setText(Con1);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount()
    {
        return countries.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView Name;
        private TextView Capital;
        ImageView Flag;
        private  TextView Region;
        private  TextView SubRegion;
        private  TextView Population;
        private  TextView Borders;
        private  TextView Languages;
        private ImageView post;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            Name= itemView.findViewById(R.id.CountryNameId);
            Flag= (ImageView) itemView.findViewById(R.id.flag_image);
            Capital= itemView.findViewById(R.id.CapitalValue);
            Region= itemView.findViewById(R.id.ReiginValue);
            SubRegion= itemView.findViewById(R.id.SubReiginValue);
            Population= itemView.findViewById(R.id.PopulationValue);
            Borders= itemView.findViewById(R.id.BordersValue);
            Languages= itemView.findViewById(R.id.LanguagesValue);
            post=itemView.findViewById(R.id.postImage);


        }
    }
}
