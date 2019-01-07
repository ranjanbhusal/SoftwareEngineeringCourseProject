package com.mumSched.services;
	import java.util.ArrayList;
	import java.util.List;

	import javax.transaction.Transactional;
	import org.springframework.stereotype.Service;

import com.mumSched.model.Entry;
import com.mumSched.repository.EntryRepository;


	@Service
	@Transactional
	public class EntryServices {
		
		private final EntryRepository entryRepository;
		
		public EntryServices(EntryRepository entryRepository) {
			this.entryRepository = entryRepository;
		}

		public void saveMyEntry(Entry entry) {
			entryRepository.save(entry);
		}
		
		public List<Entry>showAllEntry(){
			List <Entry> entries = new ArrayList<Entry>();
			
			for (Entry entry: entryRepository.findAll()) {
				entries.add(entry);
			}
			return entries;
		}
		
		public void deleteEntry(long id) {
			entryRepository.deleteById(id);
		}
		
		public Entry editUser(long id) {
			return entryRepository.findById(id).orElse(null);
		}
		


	}

