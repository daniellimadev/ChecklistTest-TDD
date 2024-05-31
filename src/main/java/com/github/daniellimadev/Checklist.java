package com.github.daniellimadev;

import java.util.*;
import java.util.stream.Collectors;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Checklist {

    private List<Tarefa> tarefas;

    public Checklist() {
        this.tarefas = new ArrayList<>();
    }

    public void addTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    public List<Tarefa> getTodasAsTarefas() {
        return new ArrayList<>(tarefas);
    }

    public List<Tarefa> getTodasAsTarefasConcluidas() {
        return tarefas.stream()
                .filter(Tarefa::isConcluida)
                .collect(Collectors.toList());
    }

    public List<Tarefa> getTodasAsTarefasPendentes() {
        return tarefas.stream()
                .filter(tarefa -> !tarefa.isConcluida())
                .collect(Collectors.toList());
    }

    public void alterarStatusTarefa(int id, boolean concluida) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.setConcluida(concluida);
                break;
            }
        }
    }

    public List<String> getTodasAsDescricoes() {
        return tarefas.stream()
                .map(Tarefa::getDescricao)
                .collect(Collectors.toList());
    }

    public List<Tarefa> getTodasAsTarefasOrdenadasPorConclusao() {
        return tarefas.stream()
                .sorted((t1, t2) -> {
                    if (t1.isConcluida() != t2.isConcluida()) {
                        return Boolean.compare(t2.isConcluida(), t1.isConcluida());
                    }
                    return t1.getDescricao().compareTo(t2.getDescricao());
                })
                .collect(Collectors.toList());
    }
}