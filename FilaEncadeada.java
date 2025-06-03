public class FilaEncadeada {
    private Node inicio, fim;

    public FilaEncadeada() {
        inicio = fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(String nome) {
        Node novo = new Node(nome);
        if (isEmpty()) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    public String dequeue() {
        if (isEmpty()) return null;
        String nome = inicio.nome;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return nome;
    }

    public String peek() {
        return isEmpty() ? null : inicio.nome;
    }

    public String listarFila() {
        StringBuilder sb = new StringBuilder();
        Node atual = inicio;
        while (atual != null) {
            sb.append(atual.nome).append("\n");
            atual = atual.proximo;
        }
        return sb.toString();
    }
}