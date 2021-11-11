package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Utils {
	public static String calculate_time_difference(String start_time, String end_time) {

		SimpleDateFormat obj = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
		String result = "";
		try {

			Date s = obj.parse(start_time);
			Date e = obj.parse(end_time);

			double time_difference = e.getTime() - s.getTime();

			return Double.toString((time_difference)) + " milli seconds";
		}

		catch (ParseException excep) {
			excep.printStackTrace();

		}
		return result;
	}

	// For generating the dataset based in the command line input
	public static int[] generateDataSet(int size_of_data, String type_of_data) {
		int[] data_set = new int[size_of_data];
		int i = 0;

		switch (type_of_data) {
		case "constant":
			while (i < size_of_data) {
				data_set[i] = 0;
				i++;

			}

			break;

		case "already sorted":
			while (i < size_of_data) {
				data_set[i] = i;
				i++;

			}

			break;

		case "random":

			while (i < size_of_data) {
				data_set[i] = (ThreadLocalRandom.current().nextInt(0, size_of_data + 1));
				i++;

			}

			break;

		default:
			break;
		}

		return data_set;
	}

	// To check the result after calling the algorithm is sorted or not
	public static boolean isSorted(int[] array) {
		return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
	}

}
