import com.google.gson.Gson;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws IOException, InterruptedException {

    ArrayList<String> currencies = new ArrayList<>(List.of("USD", "ARS", "COP", "BRL"));
    // USD = Dólar; ARS = Peso Argentino; COP = Peso Colombiano; BRL = Real Brasileiro

    String minhaAPIKey = System.getenv("API_KEY");
    Boolean sair = false;

    Scanner scanner = new Scanner(System.in);
    String textoBoasVindas = "Seja bem-vindo/a ao Conversor de Moeda\n" +
            "1) Dólar =>> Peso Argentino\n" +
            "2) Peso Argentino =>> Dólar\n" +
            "3) Dólar =>> Real Brasileiro\n" +
            "4) Real Brasileiro =>> Dólar\n" +
            "5) Dólar =>> Peso Colombiano\n" +
            "6) Peso Colombiano =>> Dólar\n" +
            "7) Sair\n";
    IO.println(textoBoasVindas);

    int opcao = scanner.nextInt();

    IO.println("Insira o valor a ser convertido:");
    double valor = scanner.nextDouble();

    int valor1 = 0, valor2 = 0;



    switch (opcao) {
        case 1:
            // Dólar =>> Peso Argentino
             valor1 = 0; // USD
             valor2 = 1; // ARS
            IO.println("Convertendo Dólar para Peso Argentino...");
            break;
        case 2:
            // Peso Argentino =>> Dólar
            valor1 = 1; // ARS
            valor2 = 0; // USD
            IO.println("Convertendo Peso Argentino para Dólar...");
            break;
        case 3:
            // Dólar =>> Real Brasileiro
            valor1 = 0; // USD
            valor2 = 3; // BRL
            IO.println("Convertendo Dólar para Real Brasileiro...");
            break;
        case 4:
            // Real Brasileiro =>> Dólar
            valor1 = 3; // BRL
            valor2 = 0; // USD
            IO.println("Convertendo Real Brasileiro para Dólar...");
            break;
        case 5:
            // Dólar =>> Peso Colombiano
            valor1 = 0; // USD
            valor2 = 2; // COP
            IO.println("Convertendo Dólar para Peso Colombiano...");
            break;
        case 6:
            // Peso Colombiano =>> Dólar
            valor1 = 2; // COP
            valor2 = 0; // USD
            break;
        case 7:
            IO.println("Saindo do programa. Até mais!");
            sair = true;
            scanner.close();
            break;
        default:
            IO.println("Opção inválida. Por favor, tente novamente.");

    }
    if (!sair) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/"
                        + minhaAPIKey
                        + "/pair/" + currencies.get(valor1) + "/"
                        + currencies.get(valor2) + "/"
                        + valor))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        ConversaoCambio conversao = gson.fromJson(response.body(), ConversaoCambio.class);

        IO.println(valor + " convertido é: " + conversao.getConversionResult());
    }
}
