class LRUCache : public Cache {
public:
	LRUCache(int capacity) {
		cp = capacity;
		head = nullptr;
		tail = nullptr;
	}
	void set(int key, int value) override {
		Node* n = mp[key];
		if (n != nullptr) {
			n->value = value;
		}
		else {
			n = new Node(tail, nullptr, key, value);
			mp[key] = n;
			if (head == nullptr) {
				head = n;
			}
			if (tail == nullptr) {
				tail = n;
			}
			else {
				n->prev = tail;
				tail->next = n;
				tail = n;
			}

			while (mp.size() > cp) {
				Node* oldHead = head;
				head = head->next;
				head->prev = nullptr;
				mp.erase(oldHead->key);
				delete oldHead;
			}
		}
	}
	int get(int key) override {
		Node* n = mp[key];
		if (n != nullptr) {
			if (tail != n) {
				Node* prev = n->prev;
				Node* next = n->next;
				if (prev != nullptr) {
					prev->next = next;
				}
				if (next != nullptr) {
					next->prev = prev;
				}
				if (head == n) {
					head = next;
				}
				if (head == nullptr) {
					head = n;
				}
				tail->next = n;
				n->prev = tail;
				n->next = nullptr;
				tail = n;
			}
			return n->value;
		}
		return -1;
	}
};
