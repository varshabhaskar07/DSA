class Solution {
public:
    unordered_map<string, unordered_map<string, double>> graph;

    // DFS function to find the product path from start to end
    double dfs(string start, string end, unordered_set<string>& visited) {
        // If not found
        if (graph.find(start) == graph.end() || graph.find(end) == graph.end())
            return -1.0;
        
        if (start == end)
            return 1.0;

        visited.insert(start);
        
        for (auto& neighbor : graph[start]) {
            if (visited.count(neighbor.first)) continue;
            double result = dfs(neighbor.first, end, visited);
            if (result != -1.0)
                return neighbor.second * result;
        }
        return -1.0;
    }

    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            string a = equations[i][0];
            string b = equations[i][1];
            double val = values[i];

            graph[a][b] = val;
            graph[b][a] = 1.0 / val;
        }

        vector<double> results;
        for (auto& query : queries) {
            string start = query[0], end = query[1];
            unordered_set<string> visited;
            double res = dfs(start, end, visited);
            results.push_back(res);
        }

        return results;
    }
};
