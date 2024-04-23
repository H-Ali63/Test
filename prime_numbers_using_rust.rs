extern crate threadpool;

use threadpool::ThreadPool;
use std::sync::mpsc::channel;
use std::sync::{Arc,RwLock};

const NUM_PRIMES: u64 = 100;
const NUM_THREADS: usize = 3;

fn main()
{
	let pool = ThreadPool::new(NUM_THREADS);
	let primes = Arc::new(RwLock::new(vec![2]));
	let mut count = 1;
	let (tx,rx) = channel();

	tx.send(2).unwrap();

	println!("Meow.");

	for last in rx.iter()
	{
		count += 1;
		if count >= NUM_PRIMES
		{
			break;
		}
		for num in ((last-1)*(last-1)+2)..(last*last+2)
		{
			if num>NUM_PRIMES
			{
				break;
			}
			let tx = tx.clone();
			let primes = primes.clone();
			pool.execute(move||
			{
				for i in primes.read().unwrap().iter()
				{
					if num%i==0
					{
						tx.send(num).unwrap();
						return;
					}
				}
				primes.write().unwrap().push(num);
				tx.send(num).unwrap();
			});
		}
	}
	
	let primes = primes.clone();
	for i in primes.read().unwrap().iter()
	{
		println!("{}",i);
	}
}
