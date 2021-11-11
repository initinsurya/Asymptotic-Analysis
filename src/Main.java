import java.text.SimpleDateFormat;
import java.util.Date;

import algorithms.InsertionSort;
import algorithms.QuickSort;
import algorithms.SelectionSort;
import utils.Utils;

public class Main {

	public static void main(String[] args) {

		String sorting_type = args[0];
		String sorting_name = sorting_type.equalsIgnoreCase("s") ? "SelectionSort"
				: sorting_type.equalsIgnoreCase("i") ? "InsertionSort" : "QuickSort";

		// StartTime
		new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(new Date()).toString();

		String type_of_data = args[2].equalsIgnoreCase("c") ? "constant"
				: args[2].equalsIgnoreCase("s") ? "already sorted" : "random";

		int size_of_data = Integer.parseInt((args[1]));

		int[] data_set = new int[size_of_data];

		data_set = Utils.generateDataSet(size_of_data, type_of_data);

		String end_time;

		Boolean isSorted;

		// CallTime
		String call_time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(new Date()).toString();

		switch (sorting_type) {
		case "s":

			SelectionSort.selectionSort(data_set);

			break;

		case "i":

			InsertionSort.insertionSort(data_set);

			break;

		case "q":

			QuickSort.quickSort(data_set, 0, size_of_data - 1);

			break;

		default:
			System.out.println("wrong input");

		}

		// EndTime
		end_time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(new Date()).toString();

		isSorted = Utils.isSorted(data_set);

		if (isSorted) {
			System.out.println(Utils.calculate_time_difference(call_time, end_time));
			System.out.println(
					(isSorted ? "Data correctly sorted after running " : "Data incorrectly sorted after running ")
							+ sorting_name);

		}

	}

}
