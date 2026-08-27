class Solution:
    def evalRPN(self, tokens: List[str]) -> int:

        stack = []

        for token in tokens:

            # Edge case where stack is empty when computing
            if not stack and token in ["+", "-", "*", "/"]:
                return

            if token == '+':
                second = stack.pop()
                first = stack.pop()
                stack.append(first + second)

            elif token == '-':
                second = stack.pop()
                first = stack.pop()
                stack.append(first - second)

            elif token == '*':
                second = stack.pop()
                first = stack.pop()
                stack.append(first * second)

            elif token == '/':
                second = stack.pop()
                first = stack.pop()
                stack.append(int(first / second))
            else:
                stack.append(int(token))

        
        return stack[-1]