package com.enes.moviecollection.controller;

import com.enes.moviecollection.model.Actor;
import com.enes.moviecollection.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/actors")
    public String viewActorPage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/actors/showNewActorForm")
    public String showNewMovieForm(Model model) {
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "new_actor";
    }

    @PostMapping("/actors/saveActor")
    public String saveActor(@ModelAttribute("actor") Actor actor, Long movieId) {
        actorService.saveActor(actor, movieId);
        return "redirect:/actors/";
    }

    @GetMapping("/actors/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Actor actor = actorService.getActorById(id);
        model.addAttribute("actor", actor);
        return "update_actor";
    }

    @GetMapping("/actors/deleteActor/{id}")
    public String deleteActor(@PathVariable(value = "id") long id) {
        this.actorService.deleteActorById(id);
        return "redirect:/actors/";
    }


    @GetMapping("/actors/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Actor> page = actorService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Actor> listActors = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listActors", listActors);
        return "actors";
    }
}
