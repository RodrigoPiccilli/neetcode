class Solution:
    def evalRPN(self, tokens: List[str]) -> int:

        stack = []

        for token in tokens:

            # Edge case where stack is empty when computing
            if not stack and token in ["+", "-", "*", "/"]:
                return

            match token:
                case '+':
                    second, first = stack.pop(), stack.pop()
                    stack.append(first + second)
                case '-':
                    second, first = stack.pop(), stack.pop()
                    stack.append(first - second)

                case '*':
                    second, first = stack.pop(), stack.pop()
                    stack.append(first * second)

                case '/':
                    second, first = stack.pop(), stack.pop()
                    stack.append(int(first / second))
                case _:
                    stack.append(int(token))

        return stack[-1]