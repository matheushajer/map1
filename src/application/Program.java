package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votos = new LinkedHashMap<>();

		System.out.print("Enter a file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {

				String fields[] = itemCsv.split(",");
				String name = fields[0];
				int quantity = Integer.parseInt(fields[1]);

				//verificação se já existe uma key com o valor informado e soma dos votos para keys repetidas.
				if (votos.containsKey(name)) {
					int votosAntigos = votos.get(name);
					votos.put(name, quantity + votosAntigos);
				} else {
					votos.put(name, quantity);
				}

				itemCsv = br.readLine();
			}
			
			//apresentação dos valores do map
			for (String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error");
		}

		sc.close();
	}
}
//LinkedHashMap - elementos na ordem que são adicionados.