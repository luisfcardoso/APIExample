package com.luis.apiexample.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String description;

    @NotNull
    @Column(name = "due_date")
    private LocalDate dueDate; 

    @Column(name = "payment_date")    
    private LocalDate paymentDate;

    @NotNull
    private BigDecimal amount; 
    private String note;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private EntryType type;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personId;

    public Entry() {
    }

    public Entry(Long id, String description, LocalDate dueDate, LocalDate paymentDate, BigDecimal amount, String note, EntryType type, Category categoryId, Person personId) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.note = note;
        this.type = type;
        this.categoryId = categoryId;
        this.personId = personId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public EntryType getType() {
        return this.type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    public Category getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Person getPersonId() {
        return this.personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Entry id(Long id) {
        this.id = id;
        return this;
    }

    public Entry description(String description) {
        this.description = description;
        return this;
    }

    public Entry dueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Entry paymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public Entry amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Entry note(String note) {
        this.note = note;
        return this;
    }

    public Entry type(EntryType type) {
        this.type = type;
        return this;
    }

    public Entry categoryId(Category categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Entry personId(Person personId) {
        this.personId = personId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) o;
        return Objects.equals(id, entry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            "}";
    }
}