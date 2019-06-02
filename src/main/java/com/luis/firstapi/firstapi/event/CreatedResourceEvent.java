package com.luis.firstapi.firstapi.event;

import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class CreatedResourceEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private HttpServletResponse response;
    private Long id;

    public CreatedResourceEvent(Object source, HttpServletResponse response, Long id) {
        super(source);
        this.id = id;
        this.response = response;
    }

    public HttpServletResponse getResponse() {
        return this.response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreatedResourceEvent response(HttpServletResponse response) {
        this.response = response;
        return this;
    }

    public CreatedResourceEvent id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreatedResourceEvent)) {
            return false;
        }
        CreatedResourceEvent createdResourceEvent = (CreatedResourceEvent) o;
        return Objects.equals(response, createdResourceEvent.response) && Objects.equals(id, createdResourceEvent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, id);
    }

    @Override
    public String toString() {
        return "{" +
            " response='" + getResponse() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }    

}