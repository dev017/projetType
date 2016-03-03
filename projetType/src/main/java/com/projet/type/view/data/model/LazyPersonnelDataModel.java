package com.projet.type.view.data.model;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.projet.type.entity.Personne;
import com.projet.type.service.data.IPersonneService;
import com.projet.type.view.util.Utils;

public class LazyPersonnelDataModel extends LazyDataModel<Personne> {

	private static final long serialVersionUID = 1109066180633319636L;

	private static final Logger LOG = LoggerFactory.getLogger(LazyPersonnelDataModel.class);

	private List<Personne> dataSource;

	private IPersonneService service;

	@Override
	public Object getRowKey(Personne personne) {
		return personne.getId();
	}

	@Override
	public Personne getRowData(String rowKey) {
		for (Personne personne : dataSource) {
			if (personne.getId().equals(rowKey)) {
				return personne;
			}
		}
		return null;
	}

	public LazyPersonnelDataModel(IPersonneService service) {
		this.service = service;
	}

	@Override
	public List<Personne> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		// sort
		Direction direction = null;
		if (sortOrder == SortOrder.ASCENDING) {
			direction = Direction.ASC;
		} else {
			direction = Direction.DESC;
		}

		Pageable pageable = new PageRequest(first / pageSize, pageSize, direction, sortField);

		Page<Personne> data;

		String id = "";
		String nom = "";

		if (filters != null) {
			for (String filterProperty : filters.keySet()) {

				Object filterValue = filters.get(filterProperty);

				switch (filterProperty) {
				case "id":
					id = (String) filterValue;
					break;
				case "nom":
					nom = (String) filterValue;
					break;

				default:
					break;
				}
			}
		}

		data = service.findArchiveTask(Utils.formatSearchText(nom), pageable);

		this.setRowCount((int) data.getTotalElements());
		this.dataSource = data.getContent();

		return dataSource;
	}

}
