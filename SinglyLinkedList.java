public void swap(){
    if (size <= 1){
        return;
    }

    List<Node<E>> nodes = new ArrayList<>(size);
    for (Node<E> current = head; current != null; current = current.getNext()){
        nodes.add(current);
    }

    Integer[] byValue = new Integer[size];
    for (int i = 0; i < size; i++){
        byValue[i] = i;
    }
    Arrays.sort(byValue, (a, b) -> nodes.get(a).getElement().compareTo(nodes.get(b).getElement()));

    for (int i = 0; i < size / 2; i++){
        int lowIndex = byValue[i];
        int highIndex = byValue[size - 1 - i];
        Node<E> lowNode = nodes.get(lowIndex);
        nodes.set(lowIndex, nodes.get(highIndex));
        nodes.set(highIndex, lowNode);
    }

    for (int i = 0; i < size - 1; i++){
        nodes.get(i).setNext(nodes.get(i + 1));
    }
    nodes.get(size - 1).setNext(null);
    head = nodes.get(0);
    tail = nodes.get(size - 1);
}