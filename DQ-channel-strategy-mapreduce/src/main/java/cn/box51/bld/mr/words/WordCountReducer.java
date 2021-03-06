package cn.box51.bld.mr.words;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by wq on 2018/1/9.
 */
public class WordCountReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

    public void reduce(Text key , Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {

        int c = 0;
        for(IntWritable i : values){
            c+=i.get();
        }
        context.write(new Text(key),new IntWritable(c));
    }
}
