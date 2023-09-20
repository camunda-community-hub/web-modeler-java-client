package org.camunda.community.webmodeler.client.springboot;

import org.camunda.community.webmodeler.client.dto.PubSearchDtoProjectMetadataDto;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class PrintModels {

    @Autowired
    private CamundaWebModelerApi camundaWebModelerApi;

    @PostConstruct
    public void print() throws ApiException {
        print("Projects", camundaWebModelerApi.projectsApi().searchProjects(new PubSearchDtoProjectMetadataDto()).getItems());
    }

    private void print(String name, List elements) {
        System.out.println(name + ":");

        for (Object e : elements) {
             System.out.println(e);
        }
    }
}
