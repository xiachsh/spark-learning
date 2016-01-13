package spark.test;

import scala.Tuple2;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.JavaSparkContext;


import java.util.*;
import java.util.concurrent.*;

public class GetMax
{
	static class People
	{
		private short age;
		private String name;
		private float salary;
		private String title;
		
		public People(short _age,String _name, float _salary,String _title)
		{
			this.age = _age;
			this.name = _name;
			this.salary = _salary;
			this.title = _title;
		}
		
		public String toString()
		{
			String tmp = "(";
			tmp = tmp + name + "," + age + "," + title ;
			tmp = tmp + ")";
			return tmp; 	
		}
	}


	public static void main(String [] args)
	{
		SparkConf sparkConf = new SparkConf().setAppName("tmp");
		JavaSparkContext jsc = new JavaSparkContext(sparkConf);
		
		JavaRDD<String> lines = jsc.textFile(args[0]);
		
		List<String> arr = lines.collect();

		for (String str : arr)
		{
			System.out.println(str);
		}
	}
}
