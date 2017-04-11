import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 


public class M extends Mapper<LongWritable, Text,LongWritable, Text> {
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] data=value.toString().split(Pattern.quote("|"));
		if(!(data[0].equals("NA")||data[1].equals("NA")))
		{
		context.write(key,value);
		}
	}