package ch.foufouillons.suttrbox;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

class GiggleAdapter extends RecyclerView.Adapter<GiggleAdapter.GiggleHolder> {

    private Context context;
    private ArrayList<Giggle> giggles;
    private MediaPlayer mediaPlayer;

    GiggleAdapter(ArrayList<Giggle> giggles, Context context){
        this.giggles = giggles;
        this.context = context;
        this.mediaPlayer = new MediaPlayer();
    }

    @Override
    public GiggleAdapter.GiggleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new GiggleHolder(v);
    }

    @Override
    public void onBindViewHolder(GiggleAdapter.GiggleHolder holder, int position) {
        final Giggle giggle = giggles.get(position);
        holder.bindGiggle(giggle);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(giggle.getFilename());
            }
        });
    }

    private void play(String fileName){
        try {
            mediaPlayer.stop();
        }catch (IllegalStateException ignored){

        }

        int sound_id = context.getResources().getIdentifier(fileName, "raw",
                context.getPackageName());
        if(sound_id != 0) {
            mediaPlayer = MediaPlayer.create(context, sound_id);
            mediaPlayer.start();
        }
    }

    @Override
    public int getItemCount() {
        return giggles.size();
    }

    static class GiggleHolder extends RecyclerView.ViewHolder{
        private Giggle giggle;
        private Button button;

        GiggleHolder(View v) {
            super(v);
            button = (Button)v.findViewById(R.id.recyclerview_item_button);
        }

        void bindGiggle(Giggle giggle){
            this.giggle = giggle;
            this.button.setText(this.giggle.getTitle());
        }
    }
}
