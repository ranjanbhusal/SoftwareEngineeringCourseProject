package com.mumSched.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.mumSched.model.Block;
import com.mumSched.repository.BlockRepository;

@Service
@Transactional
public class BlockServices {

	private final BlockRepository blockRepository;

		public BlockServices(BlockRepository blockRepository) {
		this.blockRepository = blockRepository;
	}

		public void saveMyBlock(Block block) {
			blockRepository.save(block);
		}
		
		public List<Block>showAllBlock(){
			List <Block> blocks = new ArrayList<Block>();
			for (Block block: blockRepository.findAll()) {
				blocks.add(block);
			}
			return blocks;
		}
		
		public void deleteBlock(long id) {
			blockRepository.deleteById(id);
		}
		
		public Block editBlock(long id) {
			return blockRepository.findById(id).orElse(null);
		}

}
