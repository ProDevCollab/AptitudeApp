package com.javaProject.AptitudeApp.service;

import com.javaProject.AptitudeApp.dao.ICategoryRepo;
import com.javaProject.AptitudeApp.dao.ILearningResourceRepo;
import com.javaProject.AptitudeApp.dao.ITopicRepo;
import com.javaProject.AptitudeApp.model.Category;
import com.javaProject.AptitudeApp.model.LearningResource;
import com.javaProject.AptitudeApp.model.Topic;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Service
public class tempAddData {

//	@Autowired
	private ICategoryRepo categoryRepo;

//	@Autowired
	private ITopicRepo topicRepo;

//	@Autowired
	private ILearningResourceRepo lrRepo;

	@Transactional
	public void addData() {
		List<Category> categories = Arrays.asList(new Category("Quantitative Aptitude"),
				new Category("Logical Aptitude"));
		categoryRepo.saveAll(categories);

		// ---- Quantitative Topics ----
		String[] quantitativeTopics = { "Time and Work", "Time and Distance", "Boats and Streams",
				"Ratio and Proportion", "Problems on Age", "Area", "Permutation and Combination", "Probability",
				"Simple Interest", "Compound Interest", "Number System", "Geometry" };

		String[] logicalTopics = { "Clock", "Calendar", "Direction Sense Test", "Blood Relations",
				"Water and Mirror Images", "Sitting Arrangement", "Venn Diagram & Dot Fixing", "Syllogism",
				"Letter Series", "Number Series", "Coding-Decoding" };

		// find-category-by-id
		Category cat1 = categoryRepo.findById(1l).get();
		Category cat2 = categoryRepo.findById(2l).get();

		// Save Quantitative topics
		List<Topic> topics = new ArrayList<>();

		for (String t : quantitativeTopics) {
//			topics.add(new Topic(t, cat1)); constructor without slug

		}
		topicRepo.saveAll(topics);

		// Save Logical topics
		topics = new ArrayList<>();
		for (String t : logicalTopics) {
//			topics.add(new Topic(t, cat2)); constructor without slug
		}
		topicRepo.saveAll(topics);

		// save learning resource urls
		List<LearningResource> lrList = new ArrayList<>();


		String[][] lrUrls = new String[][] {
		    // --- Quantitative Aptitude (Topics 1 to 12) ---
		    // { Topic ID, URL }
		    {"1", "https://youtu.be/o7pY9hCqDZk?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"2", "https://youtu.be/S9FNu8vrvI4?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"3", "https://youtu.be/HUMISdejRmw?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"4", "https://youtu.be/UzH3Q2vqAxc?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"5", "https://youtu.be/HYyPAxHAJyk?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"6", "https://youtu.be/DCo_1uY4pSE?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"7", "https://youtu.be/9pqePR1hAxQ?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"8", "https://youtu.be/8Q-uhgxvV5s?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"9", "https://youtu.be/193rcgrkUcI?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"10", "https://youtu.be/SCF44DHpFuY?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"11", "https://youtu.be/39Hbzfik_zw?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},
		    {"12", "https://youtu.be/YIFswAXE0BE?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"},

		    // --- Logical Aptitude (Sequential IDs 13-23) ---
		    {"13", "https://youtu.be/qDkaSVKyDXA?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Clock
		    {"13", "https://youtu.be/NSghGQum3EI?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Clock

		    {"14", "https://youtu.be/VW0XH_clKE4?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Calendar
		    {"14", "https://youtu.be/iiSvQ7FNVmA?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Calendar

		    {"15", "https://youtu.be/_Xj2Ux_RO8o?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Direction Sense Test
		    {"16", "https://youtu.be/6DNzpn8uhwc?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Blood Relations
		    {"17", "https://youtu.be/H6HQzVUelTI?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Water and Mirror Images

		    {"18", "https://youtu.be/qZeIDdAVvTQ?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Sitting Arrangement
		    {"18", "https://youtu.be/pYL9ADHxELI?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Sitting Arrangement

		    {"19", "https://youtu.be/t4vpUg8lP4E?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Venn Diagram & Dot Fixing
		    {"20", "https://youtu.be/mStJh_0mO0s?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Syllogism

		    {"21", "https://youtu.be/HPMYh45AIRw?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Letter Series
		    {"21", "https://youtu.be/5ooKsdKSjBo?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Letter Series

		    {"22", "https://youtu.be/nfovdgA2tuw?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Number Series
		    {"22", "https://youtu.com/_qiU_YGGZBg?list=PL8p2I9GklV454LdGfDOw0KkNazKuA-6B2"}, // Number Series

		    {"23", "https://www.youtube.com/watch?v=p3qT5ETyl0A"} // Coding-Decoding (Placeholder URL)
		};
			
		for(String[] lrUrl : lrUrls) {
			
			lrList.add(new LearningResource(
					topicRepo.findById(Long.valueOf(lrUrl[0])).get(), 
					lrUrl[1]));			
		}
		lrRepo.saveAll(lrList);

	}

}
