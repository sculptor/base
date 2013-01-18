#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.rest;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContext;
import org.fornax.cartridges.sculptor.framework.errorhandling.ServiceContextStore;
import ${package}.sample.domain.Planet;
import ${package}.sample.exception.PlanetNotFoundException;
import ${package}.sample.serviceapi.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Controller
public class PlanetController {

    private static final Log log = LogFactory.getLog(PlanetController.class.getName());

    @Autowired
    private PlanetService planetService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));
    }

    @RequestMapping(value = "/planet/form", method = RequestMethod.GET)
    public String createForm(org.springframework.ui.ModelMap modelMap) {
        modelMap.addAttribute("planet", new Planet());
        return "planet/create";
    }

    @RequestMapping(value = "/planet", method = RequestMethod.POST)
    public String create(@ModelAttribute("planet") Planet planet, BindingResult result) {
        if (planet == null) {
            throw new IllegalArgumentException("A planet is required");
        }
        if (result.hasErrors()) {
            return "planet/create";
        }

        Planet savedPlanet = planetService.save(serviceContext(), planet);

        return "redirect:/rest/planet/" + savedPlanet.getId().getId();
    }

    @RequestMapping(value = "/planet/{id}/form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) throws PlanetNotFoundException {
        Assert.notNull(id, "Identifier must be provided.");
        Planet planet = findPlanet(id);
        modelMap.addAttribute("planet", planet);
        return "planet/update";
    }

    @RequestMapping(value = "/planet/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable("id") Long id, @ModelAttribute("planet") Planet planet, BindingResult result)
            throws PlanetNotFoundException {
        Assert.notNull(id, "Identifier must be provided.");
        Assert.notNull(planet, "Planet must be provided.");

        Planet existingPlanet = findPlanet(id);
        existingPlanet.setName(planet.getName());
        existingPlanet.setMessage(planet.getMessage());
        existingPlanet.setVersion(planet.getVersion());

        if (result.hasErrors()) {
            return "planet/update";
        }

        planetService.save(serviceContext(), existingPlanet);

        return "redirect:/rest/planet/" + id;
    }

    @RequestMapping(value = "/planet/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, ModelMap modelMap) throws PlanetNotFoundException {
        Planet planet = findPlanet(id);
        modelMap.addAttribute("planet", planet);
        return "planet/show";
    }

    private Planet findPlanet(Long id) throws PlanetNotFoundException {
        Assert.notNull(id, "Identifier must be provided.");
        Key planetKey = planetKey(id);
        return planetService.findById(serviceContext(), planetKey);
    }

    @RequestMapping(value = "/planet", method = RequestMethod.GET)
    public String showAll(ModelMap modelMap) {
        List<Planet> planetList = planetService.findAll(serviceContext());
        modelMap.addAttribute("planetList", planetList);
        return "planet/list";
    }

    @RequestMapping(value = "/planet/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, ModelMap modelMap) throws PlanetNotFoundException {
        Planet planet = findPlanet(id);
        planetService.delete(serviceContext(), planet);
        return "redirect:/rest/planet";
    }

    private Key planetKey(Long planetId) {
        Key planetKey = KeyFactory.createKey(Planet.class.getSimpleName(), planetId);
        return planetKey;
    }

    private ServiceContext serviceContext() {
        return ServiceContextStore.get();
    }

}
