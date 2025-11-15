# Conversor de Moedas

Um aplicativo console em Java que realiza conversões de moedas em tempo real utilizando a API ExchangeRate.

## 🌍 Moedas Suportadas

- 🇺🇸 **USD** - Dólar Americano
- 🇦🇷 **ARS** - Peso Argentino
- 🇨🇴 **COP** - Peso Colombiano
- 🇧🇷 **BRL** - Real Brasileiro

## 📋 Funcionalidades

O programa oferece as seguintes conversões:

1. Dólar → Peso Argentino
2. Peso Argentino → Dólar
3. Dólar → Real Brasileiro
4. Real Brasileiro → Dólar
5. Dólar → Peso Colombiano
6. Peso Colombiano → Dólar
7. Sair do programa

## 🛠️ Requisitos

- **Java 11+** (para suportar `java.net.http`)
- **Gson 2.13.2** (biblioteca JSON incluída em `Librarys/`)
- **API Key** da [ExchangeRate API](https://www.exchangerate-api.com/)

## ⚙️ Configuração

### 1. Obter API Key

1. Acesse [exchangerate-api.com](https://www.exchangerate-api.com/)
2. Crie uma conta gratuita
3. Copie sua API Key

### 2. Configurar Variável de Ambiente

Configure a variável de ambiente `API_KEY` com sua chave:

**Windows (PowerShell):**
```powershell
$env:API_KEY = "sua_chave_aqui"
```

**Windows (CMD):**
```cmd
set API_KEY=sua_chave_aqui
```

**Linux/Mac:**
```bash
export API_KEY="sua_chave_aqui"
```

## 🚀 Como Executar

1. Compile o projeto:
```bash
javac -cp "Librarys/gson-2.13.2.jar" src/*.java -d out
```

2. Execute o programa:
```bash
java -cp "out;Librarys/gson-2.13.2.jar" Main
```

## 📁 Estrutura do Projeto

```
Currency Converter Project/
├── src/
│   ├── Main.java              # Arquivo principal com o menu
│   └── ConversaoCambio.java   # Classe para armazenar resposta da API
├── Librarys/
│   └── gson-2.13.2.jar        # Biblioteca Gson para parsing JSON
└── README.md                   # Este arquivo
```

## 🔄 Como Funciona

1. O programa exibe um menu com as opções de conversão disponíveis
2. O usuário seleciona a opção desejada
3. O programa solicita o valor a converter
4. Uma requisição HTTP é enviada à API ExchangeRate
5. A resposta JSON é convertida para um objeto Java usando Gson
6. O resultado é exibido no console

## 📝 Exemplo de Uso

```
Seja bem-vindo/a ao Conversor de Moeda
1) Dólar =>> Peso Argentino
2) Peso Argentino =>> Dólar
3) Dólar =>> Real Brasileiro
4) Real Brasileiro =>> Dólar
5) Dólar =>> Peso Colombiano
6) Peso Colombiano =>> Dólar
7) Sair

Insira o valor a ser convertido:
100
Convertendo Dólar para Peso Argentino...
100.0 convertido é: 42500.0
```

## 🐛 Possíveis Problemas

### API Key não encontrada
Certifique-se de que a variável de ambiente `API_KEY` está configurada corretamente.

### Erro de conexão
Verifique sua conexão com a internet e se a API está disponível.

### ClassNotFoundException para Gson
Certifique-se de que o `gson-2.13.2.jar` está no classpath ao compilar e executar.

## 📚 Dependências

- **Gson 2.13.2** - Biblioteca para parsing/serialização JSON
- **Java HTTP Client** - Nativa do Java 11+

## 📄 Licença

Este projeto é de código aberto e livre para uso educacional.

## 👨‍💻 Autor

Desenvolvido como projeto do Challenge Conversor de moedas em Java pela Alura.

---

**Desenvolvido por com ❤️ em Java**

